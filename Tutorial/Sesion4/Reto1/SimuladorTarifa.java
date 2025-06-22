package Sesion4.Reto1;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SimuladorTarifa {
    private static final Random random = new Random();

    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("💰 Estimando tarifa...");
                TimeUnit.SECONDS.sleep(1 + random.nextInt(2)); // 1-2 segundos

                // Simula error aleatorio
                if (random.nextBoolean()) {
                    throw new RuntimeException("Error al estimar tarifa");
                }

                return 75.50;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error en estimación", e);
            }
        });
    }
}
