package ec.edu.ups.Biblioteca.service;

import java.util.List;

import ec.edu.ups.Biblioteca.business.GestionLibro;
import ec.edu.ups.Biblioteca.model.Libro;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/libros")
public class LibroService {

    @Inject
    private GestionLibro gestionLibro;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Libro> getAllLibros() {
        return gestionLibro.getAllLibros();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Libro getLibroById(@PathParam("id") Long id) {
        return gestionLibro.getLibroById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLibro(Libro libro) {
        Libro createdLibro = gestionLibro.createLibro(libro);
        return Response.status(Response.Status.CREATED).entity(createdLibro).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateLibro(@PathParam("id") Long id, Libro libro) {
        libro.setId(id);
        gestionLibro.updateLibro(libro);
        return Response.status(Response.Status.OK).entity(libro).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLibro(@PathParam("id") Long id) {
        gestionLibro.deleteLibro(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
