package Sesion5.Reto1;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MeridianPrimeControl {

    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("🌐 Iniciando monitoreo de sistemas críticos en Meridian Prime...\n");

        Flux.interval(Duration.ofMillis(500))
                .map(tick -> random.nextInt(101))
                .onBackpressureBuffer()
                .filter(nivel -> nivel > 70)
                .subscribe(nivel -> System.out.println("🚗 Alerta: Congestión del " + nivel + "% en Avenida Solar"));

        Flux.interval(Duration.ofMillis(600))
                .map(tick -> 30 + random.nextInt(71))
                .filter(pm -> pm > 50)
                .subscribe(pm -> System.out.println("🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)"));

        List<String> prioridades = List.of("Baja", "Media", "Alta");
        Flux.interval(Duration.ofMillis(800))
                .map(tick -> prioridades.get(random.nextInt(3)))
                .filter(p -> p.equals("Alta"))
                .subscribe(p -> System.out.println("🚑 Emergencia vial: Accidente con prioridad " + p));

        Flux.interval(Duration.ofMillis(700))
                .map(tick -> random.nextInt(11))
                .delayElements(Duration.ofMillis(100))
                .filter(min -> min > 5)
                .subscribe(min -> System.out.println("🚝 Tren maglev con retraso crítico: " + min + " minutos"));

        AtomicInteger rojoConsecutivo = new AtomicInteger(0);
        List<String> estados = List.of("Verde", "Amarillo", "Rojo");
        Flux.interval(Duration.ofMillis(400))
                .map(tick -> estados.get(random.nextInt(3)))
                .doOnNext(e -> {
                    if (e.equals("Rojo")) {
                        if (rojoConsecutivo.incrementAndGet() == 3) {
                            System.out.println("🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte");
                            rojoConsecutivo.set(0);
                        }
                    } else {
                        rojoConsecutivo.set(0);
                    }
                })
                .subscribe();

        Thread.sleep(10000);
        System.out.println("\n✅ Monitoreo finalizado.");
    }
}