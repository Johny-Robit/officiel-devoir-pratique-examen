package ca.ulaval.glo4002.pratique.interfaces.rest;

import ca.ulaval.glo4002.pratique.interfaces.rest.dto.ErreurRest;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CatchAllExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        var erreur = new ErreurRest(exception.getMessage());
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(erreur).build();
    }
}
