package Sesion1.Reto2;

public abstract class MaterialCurso {
    protected String titulo;
    protected String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public abstract void mostrarDetalle();
    
    public String getAutor() {
        return autor;
    }
}
