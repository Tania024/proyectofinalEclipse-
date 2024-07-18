package ec.edu.ups.Biblioteca.business;

import java.util.List;

import ec.edu.ups.Biblioteca.dao.PrestamoDAO;
import ec.edu.ups.Biblioteca.model.Prestamo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionPrestamo {

    @Inject
    private PrestamoDAO prestamoDAO;

    public List<Prestamo> getAllPrestamos() {
        return prestamoDAO.findAll();
    }

    public Prestamo getPrestamoById(int id) {
        return prestamoDAO.findById(id);
    }

    public Prestamo createPrestamo(Prestamo prestamo) {
        prestamoDAO.create(prestamo);
        return prestamo;
    }

    public void updatePrestamo(Prestamo prestamo) {
        prestamoDAO.update(prestamo);
    }

    public void deletePrestamo(int id) {
        prestamoDAO.delete(id);
    }
}
