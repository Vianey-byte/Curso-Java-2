package Sesion3.Reto1;
import java.util.List;
import java.util.Optional;

public class PizzeriaStreams {
    public static void main(String[] args) {
        // Lista de pedidos de ejemplo (algunos sin teléfono)
        List<Pedido> pedidos = List.of(
            new Pedido("Juan", "domicilio", "555-1234"),
            new Pedido("Ana", "local", null),
            new Pedido("Carlos", "domicilio", "555-5678"),
            new Pedido("Luisa", "domicilio", null),
            new Pedido("Mario", "domicilio", "555-9012")
        );

        // Procesamiento con Stream API
        pedidos.stream()
            // Filtrar solo pedidos a domicilio
            .filter(p -> "domicilio".equals(p.getTipoEntrega()))
            // Obtener teléfonos como Optional y filtrar los vacíos
            .map(Pedido::getTelefono)
            .filter(Optional::isPresent)
            // Extraer el valor del Optional y transformar a mensaje
            .map(Optional::get)
            .forEach(telefono -> 
                System.out.println("📞 Confirmación enviada al número: " + telefono)
            );
    }
}