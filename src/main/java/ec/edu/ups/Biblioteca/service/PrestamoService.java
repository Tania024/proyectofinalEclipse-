package ec.edu.ups.Biblioteca.service;

import java.util.List;

import ec.edu.ups.Biblioteca.business.GestionPrestamo;
import ec.edu.ups.Biblioteca.model.Prestamo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/prestamos")
public class PrestamoService {

    @Inject
    private GestionPrestamo gestionPrestamo;

    @GET
    @Produces("application/json")
    public List<Prestamo> getAllPrestamos() {
        return gestionPrestamo.getAllPrestamos();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Prestamo getPrestamoById(@PathParam("id") Long id) {
        return gestionPrestamo.getPrestamoById(id);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createPrestamo(Prestamo prestamo) {
        Prestamo createdPrestamo = gestionPrestamo.createPrestamo(prestamo);
        return Response.status(Response.Status.CREATED).entity(createdPrestamo).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/{id}")
    public Response updatePrestamo(@PathParam("id") Long id, Prestamo prestamo) {
        prestamo.setId(id);
        gestionPrestamo.updatePrestamo(prestamo);
        return Response.status(Response.Status.OK).entity(prestamo).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrestamo(@PathParam("id") Long id) {
        gestionPrestamo.deletePrestamo(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
