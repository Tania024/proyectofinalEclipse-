package ec.edu.ups.Biblioteca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario implements Serializable{
	 private Long id;
	 private String nombre;
	 private String apellido;
	 private String email;
	 private String password;
	 private Date fechaRegistro;
	 private boolean esAdmin;
	 private List<Libro> Libro;
	 
	 @OneToMany(mappedBy = "gestionadoPor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    
	    
	// Getters y Setters
	 
	public Long getId() {
			return id;
	}
	public List<Libro> getLibro() {
		return Libro;
	}
	public void setLibro(List<Libro> libro) {
		Libro = libro;
	}
	public void setId(Long id) {
			this.id = id;
	}
	public String getNombre() {
			return nombre;
	}
	public void setNombre(String nombre) {
			this.nombre = nombre;
	}
	public String getApellido() {
			return apellido;
	}
	public void setApellido(String apellido) {
			this.apellido = apellido;
	}
	public String getEmail() {
			return email;
	}
	public void setEmail(String email) {
			this.email = email;
	}
	public String getPassword() {
			return password;
	}
	public void setPassword(String password) {
			this.password = password;
	}
	public Date getFechaRegistro() {
			return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
	}
	public boolean isEsAdmin() {
			return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
			this.esAdmin = esAdmin;
	}
	
	//To String
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", password=" + password + ", fechaRegistro=" + fechaRegistro + ", esAdmin=" + esAdmin + ", Libro="
				+ Libro + ", getId()=" + getId() + ", getLibro()=" + getLibro() + ", getNombre()=" + getNombre()
				+ ", getApellido()=" + getApellido() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getFechaRegistro()=" + getFechaRegistro() + ", isEsAdmin()=" + isEsAdmin() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	    
	    


}
