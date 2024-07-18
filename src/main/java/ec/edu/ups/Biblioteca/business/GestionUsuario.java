package ec.edu.ups.Biblioteca.business;

import java.util.List;

import ec.edu.ups.Biblioteca.dao.UsuarioDAO;
import ec.edu.ups.Biblioteca.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUsuario {

    @Inject
    private UsuarioDAO usuarioDAO;

    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioDAO.findById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
        usuarioDAO.create(usuario);
        return usuario;
    }

    public void updateUsuario(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioDAO.delete(id);
    }
}
