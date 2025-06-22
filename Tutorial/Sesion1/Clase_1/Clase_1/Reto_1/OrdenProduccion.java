package Clase_1.Reto_1;

public abstract class OrdenProduccion {  // Nota la ortografía correcta
    protected String codigo;
    protected int cantidad;
    
    public OrdenProduccion(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }
    
    public abstract void mostrarResumen();  // Método abstracto
}
