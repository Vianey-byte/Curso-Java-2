package Clase_1.Reto_1;

public class OrdenPersonalizada extends OrdenProduccion {
    private String cliente;
    
    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad); // Llama al constructor de la clase padre
        this.cliente = cliente;
    }
    
    @Override
    public void mostrarResumen() {
        // Forma correcta de concatenar:
        System.out.println("OrdenPersonalizada - Código: " + codigo + 
                         " - Cantidad: " + cantidad + 
                         " - Cliente: " + cliente);
    }
    
    public void agregarCostoAdicional(int adicional) {
        System.out.println("Orden " + super.codigo + 
                         " ajustada con costo adicional de $" + adicional);
    }
}