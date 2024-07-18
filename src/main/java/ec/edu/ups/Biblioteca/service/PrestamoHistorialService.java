package ec.edu.ups.Biblioteca.service;

import java.util.List;

import ec.edu.ups.Biblioteca.business.GestionHistorialPrestamo;
import ec.edu.ups.Biblioteca.model.HistorialPrestamo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/historial-prestamos")
public class PrestamoHistorialService {

    @Inject
    private GestionHistorialPrestamo gestionHistorialPrestamo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{prestamoId}")
    public List<HistorialPrestamo> getHistorialByPrestamoId(@PathParam("prestamoId") Long prestamoId) {
        return gestionHistorialPrestamo.getHistorialByPrestamoId(prestamoId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addHistorial(HistorialPrestamo historialPrestamo) {
        gestionHistorialPrestamo.addHistorial(historialPrestamo);
        return Response.status(Response.Status.CREATED).entity(historialPrestamo).build();
    }
}
