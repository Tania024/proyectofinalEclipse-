package ec.edu.ups.Biblioteca.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.Biblioteca.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UsuarioDAO implements Serializable{
	@PersistenceContext
    private EntityManager em;
    
    public void insert(Usuario usuario) {
        em.persist(usuario);
    }

    public void update(Usuario usuario) {
        em.merge(usuario);
    }
    
    public Usuario read(Long id) {
        return em.find(Usuario.class, id);
    }
    
    public void delete(Long id) {
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario != null) {
            em.remove(usuario);
        }
    }
    
    public List<Usuario> getAll() {
        String jpql = "SELECT u FROM Usuario u";
        Query query = em.createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    public Usuario findByEmail(String email) {
        String jpql = "SELECT u FROM Usuario u WHERE u.email = :email";
        Query query = em.createQuery(jpql, Usuario.class);
        query.setParameter("email", email);
        List<Usuario> usuarios = query.getResultList();
        if (usuarios.isEmpty()) {
            return null;
        } else {
            return usuarios.get(0);
        }
    }

}
