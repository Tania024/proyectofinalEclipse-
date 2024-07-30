package ec.edu.ups.Biblioteca.business;

import java.util.List;

import ec.edu.ups.Biblioteca.dao.HistorialPrestamoDAO;
import ec.edu.ups.Biblioteca.model.HistorialPrestamo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionHistorialPrestamo {

    @Inject
    private HistorialPrestamoDAO historialPrestamoDAO;

    public List<HistorialPrestamo> getHistorialByPrestamoId(Long prestamoId) {
        return historialPrestamoDAO.findAllByPrestamoId(prestamoId);
    }

    public void addHistorial(HistorialPrestamo historialPrestamo) {
        historialPrestamoDAO.create(historialPrestamo);
    }
    
    public List<HistorialPrestamo> getAllHistorialPrestamo() {
        return historialPrestamoDAO.getAll();
    }

}
