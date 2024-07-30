package ec.edu.ups.Biblioteca.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ec.edu.ups.Biblioteca.business.GestionHistorialPrestamo;
import ec.edu.ups.Biblioteca.business.GestionPrestamo;
import ec.edu.ups.Biblioteca.model.HistorialPrestamo;
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

    @Inject
    private GestionHistorialPrestamo getHistorialPrestamo;
    
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
    
    @GET
    @Produces("application/json")
    @Path("/libro/{libroId}")
    public List<Prestamo> getPrestamosByLibro(@PathParam("libroId") int libroId) {
        return gestionPrestamo.getPrestamosByLibro(libroId);
    }
    
    @GET
    @Produces("application/json")
    @Path("/usuario/{usuarioId}")
    public List<Prestamo> getPrestamosByUsuario(@PathParam("usuarioId") int usuarioId) {
        return gestionPrestamo.getPrestamosByUsuario(usuarioId);
    }
    
    @GET
    @Produces("application/json")
    @Path("/caducado/{usuarioId}")
    public List<Prestamo> getPrestamosByUsuarioCaducados(@PathParam("usuarioId") int usuarioId) {
        List<Prestamo> prestamos = gestionPrestamo.getPrestamosByUsuario(usuarioId);
        Date today = new Date();
        for (Prestamo prestamo : prestamos) {
            if (isCaducado(prestamo, today)&& prestamo.getEstado()==2) {
                prestamo.setCaducado(1);
                HistorialPrestamo historial = new HistorialPrestamo();
                historial.setPrestamo(prestamo);
                historial.setDescripcion("Libro caducado");
                historial.setFechaEvento(new Date());
                historial.setTipoEvento("Prestamo");
                getHistorialPrestamo.addHistorial(historial);
                gestionPrestamo.updatePrestamo(prestamo);
                return prestamos;
            }
        }

        return null;
    }

    private boolean isCaducado(Prestamo prestamo, Date today) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(prestamo.getFechaInicio());
        cal.add(Calendar.DAY_OF_YEAR, prestamo.getDias());
        Date fechaCaducidad = cal.getTime();
        return today.after(fechaCaducidad);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createPrestamo(Prestamo prestamo) {
        prestamo.setFechaInicio(new Date());
        Prestamo createdPrestamo = gestionPrestamo.createPrestamo(prestamo);
        prestamo.setFechaFin(null);
        HistorialPrestamo historial = new HistorialPrestamo();
        historial.setPrestamo(createdPrestamo);
        historial.setDescripcion("Prestamo de libro");
        historial.setFechaEvento(new Date());
        historial.setTipoEvento("Prestamo");
        getHistorialPrestamo.addHistorial(historial);

        return Response.status(Response.Status.CREATED).entity(createdPrestamo).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/{id}")
    public Response updatePrestamo(@PathParam("id") Long id, Prestamo prestamo) {
        try {
            Prestamo existingPrestamo = gestionPrestamo.getPrestamoById(id);
            if (existingPrestamo == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            existingPrestamo.setEstado(1);
            HistorialPrestamo historial = new HistorialPrestamo();
            historial.setPrestamo(existingPrestamo);
            historial.setDescripcion("Prestamo estado devuelto");
            historial.setFechaEvento(new Date());
            historial.setTipoEvento("Prestamo actualizado");
            getHistorialPrestamo.addHistorial(historial);
            gestionPrestamo.updatePrestamo(existingPrestamo);
            return Response.ok(existingPrestamo).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrestamo(@PathParam("id") Long id) {
        gestionPrestamo.deletePrestamo(id);
        HistorialPrestamo historial = new HistorialPrestamo();
        historial.setPrestamo(gestionPrestamo.getPrestamoById(id));
        historial.setDescripcion("Eliminacion de libro ");
        historial.setFechaEvento(new Date());
        historial.setTipoEvento("Elimincion");
        getHistorialPrestamo.addHistorial(historial);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
