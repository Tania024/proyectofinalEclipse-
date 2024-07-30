package ec.edu.ups.Biblioteca.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.Biblioteca.model.HistorialPrestamo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class HistorialPrestamoDAO implements Serializable{

    @PersistenceContext()
    private EntityManager entityManager;

    public List<HistorialPrestamo> findAllByPrestamoId(Long prestamoId) {
        String jpql = "SELECT h FROM HistorialPrestamo h WHERE h.prestamo.id = :prestamoId";
        Query query = entityManager.createQuery(jpql, HistorialPrestamo.class);
        query.setParameter("prestamoId", prestamoId);
        return query.getResultList();
    }
    
    public List<HistorialPrestamo> getAll(){
        String jpql = "SELECT c FROM HistorialPrestamo c";
        Query query = entityManager.createQuery(jpql, HistorialPrestamo.class);
        return query.getResultList();
    }

    public void create(HistorialPrestamo historialPrestamo) {
        entityManager.persist(historialPrestamo);
    }
}
