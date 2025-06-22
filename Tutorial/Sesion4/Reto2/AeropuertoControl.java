package Sesion4.Reto2;
import java.util.Random;
import java.util.concurrent.*;

public class AeropuertoControl {

    private static final Random random = new Random();

    // Simula una latencia entre 2 y 3 segundos
    private static void simularLatencia() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2 + random.nextInt(2));
    }

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                simularLatencia();
                boolean disponible = random.nextInt(100) < 80; // 80% probabilidad de éxito
                System.out.println("🛣️ Pista disponible: " + disponible);
                return disponible;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error en verificación de pista");
            }
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                simularLatencia();
                boolean favorable = random.nextInt(100) < 85; // 85% probabilidad de éxito
                System.out.println("🌦️ Clima favorable: " + favorable);
                return favorable;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error en verificación del clima");
            }
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                simularLatencia();
                boolean despejado = random.nextInt(100) < 90; // 90% probabilidad de éxito
                System.out.println("🚦 Tráfico aéreo despejado: " + despejado);
                return despejado;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error en verificación del tráfico aéreo");
            }
        });
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                simularLatencia();
                boolean disponible = random.nextInt(100) < 95; // 95% probabilidad de éxito
                System.out.println("👷‍♂️ Personal disponible: " + disponible);
                return disponible;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error en verificación del personal en tierra");
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        CompletableFuture<Void> allChecks = CompletableFuture.allOf(pista, clima, trafico, personal);

        allChecks.thenRun(() -> {
            try {
                boolean condicionesOk = pista.get() && clima.get() && trafico.get() && personal.get();
                if (condicionesOk) {
                    System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                }
            } catch (Exception e) {
                System.out.println("\n🚫 Aterrizaje denegado: error en el sistema (" + e.getMessage() + ")");
            }
        }).exceptionally(ex -> {
            System.out.println("\n🚫 Aterrizaje denegado: error inesperado (" + ex.getMessage() + ")");
            return null;
        });

        // Espera para que las tareas async terminen antes de cerrar el programa
        TimeUnit.SECONDS.sleep(10);
    }
}
