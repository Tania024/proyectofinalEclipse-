package ec.edu.ups.Biblioteca.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.Biblioteca.model.Libro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class LibroDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Libro> findAll() {
        String jpql = "SELECT l FROM Libro l";
        Query query = entityManager.createQuery(jpql, Libro.class);
        return query.getResultList();
    }

    public Libro findById(Long id) {
        return entityManager.find(Libro.class, id);
    }

    public void create(Libro libro) {
        entityManager.persist(libro);
    }

    public void update(Libro libro) {
        entityManager.merge(libro);
    }

    public void delete(Long id) {
        Libro libro = findById(id);
        if (libro != null) {
            entityManager.remove(libro);
        }
    }
}
