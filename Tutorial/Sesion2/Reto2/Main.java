package Sesion2.Reto2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos el recurso compartido
        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        // 2. Creamos el ExecutorService con 4 hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // 3. Creamos los profesionales (Runnables)
        executor.submit(new Profesional(salaCirugia, "Dra. Sánchez"));
        executor.submit(new Profesional(salaCirugia, "Dr. Gómez"));
        executor.submit(new Profesional(salaCirugia, "Enfermero Juan"));
        executor.submit(new Profesional(salaCirugia, "Dra. López"));

        // 4. Cerramos el ExecutorService
        executor.shutdown();
    }
}
