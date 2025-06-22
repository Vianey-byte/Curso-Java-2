package Sesion1.Reto2;
import java.util.List;
import java.util.function.Predicate;

public class GestorMaterial {

    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("📚 Materiales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
        System.out.println();
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista) {
            total += v.getDuracion();
        }
        System.out.println("🎥 Duración total de videos: " + total + " minutos\n");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio e = (Ejercicio) obj;
                e.marcarRevisado();
                System.out.println("✅ Ejercicio '" + e.titulo + "' marcado como revisado.");
            }
        }
        System.out.println();
    }

    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("🔍 Filtrando materiales por autor:");
        for (MaterialCurso m : lista) {
            if (filtro.test(m)) {
                m.mostrarDetalle();
            }
        }
    }
}
