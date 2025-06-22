package Clase_1.Reto_1;

import java.util.List;

public class GestionOrdenes {
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista, String tipo) {
        System.out.println("\nÖrdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }
    
    public static void procesarPersonalizadas(List<OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\nProcessando Órdenes personalizadas...");
        for (OrdenPersonalizada orden : lista) {
            orden.agregarCostoAdicional(costoAdicional);
        }
    }
    
    public static void contarOrdenes(int masa, int personalizada, int prototipo) {
        System.out.println("\nResumen total de órdenes:");
        System.out.println("Producción en masa: " + masa);
        System.out.println("Personalizadas: " + personalizada);
        System.out.println("Prototipos: " + prototipo);
    }
}