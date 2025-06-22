package Sesion2.Reto2;
public class Profesional implements Runnable {
    private final RecursoMedico recurso;
    private final String nombre;

    public Profesional(RecursoMedico recurso, String nombre) {
        this.recurso = recurso;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        recurso.usar(nombre);
    }
}