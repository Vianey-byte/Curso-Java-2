package Clase_1.Reto_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear listas específicas para cada tipo
        List<OrdenMasa> listaMasa = new ArrayList<>();
        listaMasa.add(new OrdenMasa("A123", 500));
        listaMasa.add(new OrdenMasa("A124", 750));
        
        List<OrdenPersonalizada> listaPersonalizada = new ArrayList<>();
        listaPersonalizada.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        listaPersonalizada.add(new OrdenPersonalizada("P789", 150, "ClienteY"));
        
        List<OrdenPrototipo> listaPrototipo = new ArrayList<>();
        listaPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        listaPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));
        
        // Mostrar órdenes por tipo
        GestionOrdenes.mostrarOrdenes(listaMasa, "masa");
        GestionOrdenes.mostrarOrdenes(listaPersonalizada, "personalizada");
        GestionOrdenes.mostrarOrdenes(listaPrototipo, "prototipo");
        
        // Procesar órdenes personalizadas
        GestionOrdenes.procesarPersonalizadas(listaPersonalizada, 200);
        
        // Mostrar resumen
        GestionOrdenes.contarOrdenes(listaMasa.size(), listaPersonalizada.size(), listaPrototipo.size());
    }
}