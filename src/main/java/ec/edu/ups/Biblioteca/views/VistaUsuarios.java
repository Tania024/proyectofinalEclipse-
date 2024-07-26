package ec.edu.ups.Biblioteca.views;

import java.util.List;

import ec.edu.ups.Biblioteca.business.GestionClientes;
import ec.edu.ups.Biblioteca.business.GestionUsuario;
import ec.edu.ups.Biblioteca.model.Cliente;
import ec.edu.ups.Biblioteca.model.Usuario;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("usuarios")
@RequestScoped
public class VistaUsuarios {


    @Inject
    private GestionUsuario gestionUsuario;
    @Inject
    private GestionClientes gClientes;

    private Usuario nuevoUsuario = new Usuario();
    private List<Usuario> listadoUsuarios;

    private Cliente persona = new Cliente();

    private List<Cliente> listado;

    @PostConstruct
    public void init() {
        listado = gClientes.getClientes();
        listadoUsuarios = gestionUsuario.getAllUsuarios();
    }

    public List<Cliente> getListado() {
        return listado;
    }
    public void setListado(List<Cliente> listado) {
        this.listado = listado;
    }
    public Cliente getPersona() {
        return persona;
    }
    public void setPersona(Cliente persona) {
        this.persona = persona;
    }




    public List<Usuario> getListadoUsuarios() {
        return listadoUsuarios;
    }
    public void setListadoUsuarios(List<Usuario> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }
    public Usuario getNuevoUsuario() {
        return nuevoUsuario;
    }
    public void setNuevoUsuario(Usuario nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    public String guardar() {
        System.out.println( this.persona);
        try {
            nuevoUsuario.setRol(1);
            gestionUsuario.createUsuario(nuevoUsuario);
            Usuario u =  gestionUsuario.getUsuarioByUsernameAndPassword(nuevoUsuario.getUsername(),nuevoUsuario.getPassword());
            persona.setUsuario(Integer.parseInt(u.getId().toString()));
            gClientes.createCliente(persona);
            return "usuario.xhtml?faces-redirect=true";
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }

    public String logeo(){
        try {
            Usuario u =  gestionUsuario.getUsuarioByUsernameAndPassword(nuevoUsuario.getUsername(),nuevoUsuario.getPassword());
            if (u!=null){
                return "inicio.xhtml?faces-redirect=true";
            }else {
                return "error.xhtml?faces-redirect=true";
            }
        }catch (Exception e){
            System.out.println(e);
            return "error";
        }
    }

    public String login() {
        // Redirigir a la página contactos.xhtml
        return "usuario.xhtml?faces-redirect=true";
    }

    public String signUp() {
        // Redirigir a la página contactos.xhtml
        return "resgistroUsuario.xhtml?faces-redirect=true";
    } 	

}
