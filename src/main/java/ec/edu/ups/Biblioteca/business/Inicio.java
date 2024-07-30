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
	
}
