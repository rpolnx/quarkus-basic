package br.com.rpolnx.quarkus_basics.rest;

import br.com.rpolnx.quarkus_basics.model.dto.dota2.StatusDTO;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/api")
@RegisterRestClient(configKey = "dota2-api")
@RegisterClientHeaders(RequestUUIDHeaderFactory.class)
public interface Dota2Api {

    @GET
    @Path("/status")
    @Produces("application/json")
    StatusDTO getStatus();

    @GET
    @Produces("application/json")
    @Path("/${path}")
    Object getResource(@PathParam(value = "path") String path);
}
