package ec.edu.ups.Biblioteca.views;

import java.util.List;

import ec.edu.ups.Biblioteca.business.GestionLibro;
import ec.edu.ups.Biblioteca.model.Libro;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("libroBean")
@RequestScoped
public class VistaLibro {
    @Inject
    private GestionLibro gestionLibro;

    private Libro libro = new Libro();

    private List<Libro> libroList;

    @PostConstruct
    public void init() {
        libroList = gestionLibro.getAllLibros();
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    public String guardar() {
       try {
           gestionLibro.createLibro(libro);
           return "contactos.xhtml?faces-redirect=true";
       }catch (Exception e){
           e.printStackTrace();
           return "error";
       }

    }
}
