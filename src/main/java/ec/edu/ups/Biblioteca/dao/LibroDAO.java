package ec.edu.ups.Biblioteca.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.Biblioteca.model.Libro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class LibroDAO implements Serializable{
	@PersistenceContext
    private EntityManager em;
    
    public void insert(Libro libro) {
        em.persist(libro);
    }

    public void update(Libro libro) {
        em.merge(libro);
    }
    
    public Libro read(Long id) {
        return em.find(Libro.class, id);
    }
    
    public void delete(Long id) {
        Libro libro = em.find(Libro.class, id);
        if (libro != null) {
            em.remove(libro);
        }
    }
    
    public List<Libro> getAll() {
        String jpql = "SELECT l FROM Libro l";
        Query query = em.createQuery(jpql, Libro.class);
        return query.getResultList();
    }

    public List<Libro> findByCategoria(String categoria) {
        String jpql = "SELECT l FROM Libro l WHERE l.categoria = :categoria";
        Query query = em.createQuery(jpql, Libro.class);
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }
}
