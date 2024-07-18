package ec.edu.ups.Biblioteca.dao;

import java.util.List;

import ec.edu.ups.Biblioteca.model.Prestamo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PrestamoDAO {

    @PersistenceContext()
    private EntityManager entityManager;

    public List<Prestamo> findAll() {
        String jpql = "SELECT p FROM Prestamo p";
        Query query = entityManager.createQuery(jpql, Prestamo.class);
        return query.getResultList();
    }

    public Prestamo findById(int id) {
        return entityManager.find(Prestamo.class, id);
    }

    public void create(Prestamo prestamo) {
        entityManager.persist(prestamo);
    }

    public void update(Prestamo prestamo) {
        entityManager.merge(prestamo);
    }

    public void delete(int id) {
        Prestamo prestamo = findById(id);
        if (prestamo != null) {
            entityManager.remove(prestamo);
        }
    }
}
