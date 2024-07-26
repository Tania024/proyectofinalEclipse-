package ec.edu.ups.Biblioteca.service;

import java.util.List;

import ec.edu.ups.Biblioteca.business.GestionUsuario;
import ec.edu.ups.Biblioteca.model.Usuario;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioService  {

    @Inject
    private GestionUsuario gestionUsuario;

    @GET
    @Produces("application/json")
    public List<Usuario> getAllUsuarios() {
        return gestionUsuario.getAllUsuarios();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Usuario getUsuarioById(@PathParam("id") int id) {
        return gestionUsuario.getUsuarioById(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/autenticacion")
    public Response authenticateUser(@QueryParam("username") String username, @QueryParam("password") String password) {
        Usuario usuario = gestionUsuario.getUsuarioByUsernameAndPassword(username, password);
        if (usuario != null) {
            return Response.ok(usuario).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Usuario o contraseña incorrectos").build();
        }
    }

    @POST
    @Produces("application/json")
    public Response createUsuario(Usuario usuario) {
        Usuario createdUsuario = gestionUsuario.createUsuario(usuario);
        return Response.status(Response.Status.CREATED).entity(createdUsuario).build();
    }

    @PUT
    @Produces("application/json")
    @Path("/{id}")
    public Response updateUsuario(@PathParam("id") int id, Usuario usuario) {
        usuario.setId(id);
        gestionUsuario.updateUsuario(usuario);
        return Response.ok().entity(usuario).build();
    }

    @DELETE
    @Produces("application/json")
    @Path("/{id}")
    public Response deleteUsuario(@PathParam("id") int id) {
        gestionUsuario.deleteUsuario(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
