package ec.edu.ups.Biblioteca.views;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import ec.edu.ups.Biblioteca.business.GestionHistorialPrestamo;
import ec.edu.ups.Biblioteca.business.GestionLibro;
import ec.edu.ups.Biblioteca.model.HistorialPrestamo;
import ec.edu.ups.Biblioteca.model.LibroClase;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("historial")
@RequestScoped
public class VistaHistorial implements Serializable {

    @Inject
    private GestionHistorialPrestamo gestionHistorialPrestamo;

    @Inject
    private GestionLibro gestionLibro;

    private HistorialPrestamo historialPrestamo = new HistorialPrestamo();

    private LibroClase libroClase = new LibroClase();
    private List<HistorialPrestamo> historialPrestamoList;
    private List<LibroClase> claseList;

    @PostConstruct
    public void init() {
        historialPrestamoList = gestionHistorialPrestamo.getAllHistorialPrestamo();
        claseList = gestionLibro.librosReporte();
    }


    public GestionHistorialPrestamo getGestionHistorialPrestamo() {
        return gestionHistorialPrestamo;
    }

    public void setGestionHistorialPrestamo(GestionHistorialPrestamo gestionHistorialPrestamo) {
        this.gestionHistorialPrestamo = gestionHistorialPrestamo;
    }

    public HistorialPrestamo getHistorialPrestamo() {
        return historialPrestamo;
    }

    public void setHistorialPrestamo(HistorialPrestamo historialPrestamo) {
        this.historialPrestamo = historialPrestamo;
    }

    public List<HistorialPrestamo> getHistorialPrestamoList() {
        return historialPrestamoList;
    }

    public void setHistorialPrestamoList(List<HistorialPrestamo> historialPrestamoList) {
        this.historialPrestamoList = historialPrestamoList;
    }

    public GestionLibro getGestionLibro() {
        return gestionLibro;
    }

    public void setGestionLibro(GestionLibro gestionLibro) {
        this.gestionLibro = gestionLibro;
    }

    public LibroClase getLibroClase() {
        return libroClase;
    }

    public void setLibroClase(LibroClase libroClase) {
        this.libroClase = libroClase;
    }

    public List<LibroClase> getClaseList() {
        return claseList;
    }

    public void setClaseList(List<LibroClase> claseList) {
        this.claseList = claseList;
    }

    public String getNombresDeLibros() {
        return claseList.stream()
                .map(libro -> "\"" + libro.getNombreLibro() + "\"")
                .collect(Collectors.joining(", "));
    }

    public String getCantidadesDeLibros() {
        return claseList.stream()
                .map(libro -> String.valueOf(libro.getCantidad()))
                .collect(Collectors.joining(", "));
    }
}
