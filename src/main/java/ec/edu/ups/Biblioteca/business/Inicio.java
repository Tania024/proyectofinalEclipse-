package ec.edu.ups.Biblioteca.business;

import ec.edu.ups.Biblioteca.dao.HistorialPrestamoDAO;
import ec.edu.ups.Biblioteca.dao.LibroDAO;
import ec.edu.ups.Biblioteca.dao.PrestamoDAO;
import ec.edu.ups.Biblioteca.dao.UsuarioDAO;
import ec.edu.ups.Biblioteca.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	@Inject
	private UsuarioDAO daoUsuario;
	
	@Inject
	private LibroDAO daoLibro;
	
	@Inject
	private PrestamoDAO daoPrestamo;
	
	@Inject
	private HistorialPrestamoDAO daoHistorialPrestamo;
	
	@PostConstruct
	public void init() {
		
		
		Usuario usuario  = new Usuario();
		usuario.setId(1);
		usuario.setUsername("Tania01");
		usuario.setPassword(null);
		usuario.setRol("cliente");
		usuario.setCorreo("tlojano@est.ups.edu.ec");
		
		
		
	}
}
