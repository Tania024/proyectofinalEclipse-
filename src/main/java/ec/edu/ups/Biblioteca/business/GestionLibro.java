package ec.edu.ups.Biblioteca.business;

import java.util.List;

import ec.edu.ups.Biblioteca.dao.LibroDAO;
import ec.edu.ups.Biblioteca.model.Libro;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionLibro {

    @Inject
    private LibroDAO libroDAO;

    public List<Libro> getAllLibros() {
        return libroDAO.findAll();
    }

    public Libro getLibroById(Long id) {
        return libroDAO.findById(id);
    }

    public Libro createLibro(Libro libro) {
        libroDAO.create(libro);
        return libro;
    }

    public void updateLibro(Libro libro) {
        libroDAO.update(libro);
    }

    public void deleteLibro(Long id) {
        libroDAO.delete(id);
    }
}
