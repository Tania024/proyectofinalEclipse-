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
    public Usuario getUsuarioById(@PathParam("id") Long id) {
        return gestionUsuario.getUsuarioById(id);
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
    public Response updateUsuario(@PathParam("id") Long id, Usuario usuario) {
        usuario.setId(id);
        gestionUsuario.updateUsuario(usuario);
        return Response.ok().entity(usuario).build();
    }

    @DELETE
    @Produces("application/json")
    @Path("/{id}")
    public Response deleteUsuario(@PathParam("id") Long id) {
        gestionUsuario.deleteUsuario(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
