package Sesion4.Reto1;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

    public void procesarSolicitudViaje() {
        CompletableFuture<String> rutaFuture = SimuladorRuta.calcularRuta();
        CompletableFuture<Double> tarifaFuture = SimuladorTarifa.estimarTarifa();

        rutaFuture
            .thenCombine(tarifaFuture, (ruta, tarifa) -> 
                "✅ 🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa)
            .exceptionally(ex -> 
                "❌ Ocurrió un error al procesar la solicitud: " + ex.getMessage())
            .thenAccept(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
        MovilidadApp app = new MovilidadApp();
        app.procesarSolicitudViaje();

        // Da tiempo a tareas async antes de que el programa termine
        TimeUnit.SECONDS.sleep(5);
    }
}
