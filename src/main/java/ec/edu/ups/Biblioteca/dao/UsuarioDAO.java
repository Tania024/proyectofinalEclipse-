package ec.edu.ups.Biblioteca.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.Biblioteca.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UsuarioDAO {

    @PersistenceContext()
    private EntityManager entityManager;

    public List<Usuario> findAll() {
        String jpql = "SELECT c FROM Usuario c";
        Query query = entityManager.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    public Usuario findById(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    public void create(Usuario usuario) {
        entityManager.persist(usuario);
    }

    public void update(Usuario usuario) {
        entityManager.merge(usuario);
    }

    public void delete(Long id) {
        Usuario usuario = findById(id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

}
