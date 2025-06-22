package Sesion3.Reto1;
import java.util.Optional;

public class Pedido {
    private final String cliente;
    private final String tipoEntrega;
    private final String telefono;

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    // Devuelve el teléfono como Optional
    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }

    // Getter para tipoEntrega
    public String getTipoEntrega() {
        return tipoEntrega;
    }
}