import java.util.concurrent.*;

public class MisionEspacial {
    public static void main(String[] args) {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        // Crear un pool de hilos con 4 hilos (uno para cada subsistema)
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            // Enviar las tareas al executor y obtener los Futures
            Future<String> navegacionFuture = executor.submit(new SistemaNavegacion());
            Future<String> soporteVitalFuture = executor.submit(new SistemaSoporteVital());
            Future<String> controlTermicoFuture = executor.submit(new SistemaControlTermico());
            Future<String> comunicacionesFuture = executor.submit(new SistemaComunicaciones());

            // Esperar y mostrar los resultados de cada subsistema
            System.out.println(comunicacionesFuture.get());
            System.out.println(soporteVitalFuture.get());
            System.out.println(controlTermicoFuture.get());
            System.out.println(navegacionFuture.get());

            System.out.println("✅ Todos los sistemas reportan estado operativo.");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error en la simulación: " + e.getMessage());
        } finally {
            // Cerrar el executor
            executor.shutdown();
        }
    }
}

class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simular procesamiento
        Thread.sleep((long) (Math.random() * 2000 + 1000));
        return "🛰️ Navegación: trayectoria corregida con éxito.";
    }
}

class SistemaSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simular procesamiento
        Thread.sleep((long) (Math.random() * 2000 + 1000));
        return "🧪 Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}

class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simular procesamiento
        Thread.sleep((long) (Math.random() * 2000 + 1000));
        return "🔥 Control térmico: temperatura estable (22°C).";
    }
}

class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simular procesamiento
        Thread.sleep((long) (Math.random() * 2000 + 1000));
        return "📡 Comunicaciones: enlace con estación terrestre establecido.";
    }
}
