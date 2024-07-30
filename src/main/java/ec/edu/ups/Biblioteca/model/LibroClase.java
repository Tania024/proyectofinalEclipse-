package ec.edu.ups.Biblioteca.model;

public class LibroClase {
    private int cantidad;
    private String nombreLibro;

    public LibroClase() {
    }

    public LibroClase(Long cantidad, String nombreLibro) {
        this.cantidad = cantidad.intValue(); // Conversión de Long a int
        this.nombreLibro = nombreLibro;
    }

    // Getters y setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }
}
