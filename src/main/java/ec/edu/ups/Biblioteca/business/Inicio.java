package ec.edu.ups.Biblioteca.business;

import java.util.Date;

import ec.edu.ups.Biblioteca.dao.HistorialPrestamoDAO;
import ec.edu.ups.Biblioteca.dao.LibroDAO;
import ec.edu.ups.Biblioteca.dao.PrestamoDAO;
import ec.edu.ups.Biblioteca.dao.UsuarioDAO;
import ec.edu.ups.Biblioteca.model.HistorialPrestamo;
import ec.edu.ups.Biblioteca.model.Libro;
import ec.edu.ups.Biblioteca.model.Prestamo;
import ec.edu.ups.Biblioteca.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject
	private LibroDAO libroDAO;
	
	@Inject
	private PrestamoDAO prestamoDAO;
	
	@Inject
	private HistorialPrestamoDAO historialPrestamoDAO;
	
	@PostConstruct
	public void init() {
		
		
		Usuario usuario  = new Usuario();
		usuario.setUsername("Tania01");
		usuario.setPassword("adimin");
		usuario.setRol(1);
		usuario.setCorreo("tlojano@est.ups.edu.ec");
		
		usuarioDAO.create(usuario);
		
		Libro libro = new Libro();
		libro.setAnioPublicacion(1923);
		libro.setAutor("Rosa");
		libro.setIsbn("12-34556-689");
		libro.setTitulo("Vida solo hay una");
		
		libroDAO.create(libro);
		
		
		Prestamo prestamo = new Prestamo();
		prestamo.setEstado("Disponible");
		//prestamo.setFechaFin(null);
		//prestamo.setFechaInicio(null);
		prestamo.setMonto(45678.0);
		prestamo.setTasaInteres(4.6);
		prestamo.setUsuario(usuario);
		
		prestamoDAO.create(prestamo);
		
		
		HistorialPrestamo historialPrestamo = new HistorialPrestamo();
		historialPrestamo.setDescripcion("El cliente realizó un pago parcial del préstamo.");
		//historialPrestamo.setFechaEvento(null);
		historialPrestamo.setTipoEvento("Pago realizado");
		historialPrestamo.setPrestamo(prestamo);
		
		historialPrestamoDAO.create(historialPrestamo);
		
	}
}
