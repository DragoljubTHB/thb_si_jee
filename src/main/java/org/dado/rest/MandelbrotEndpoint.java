package org.dado.rest;

import org.dado.repository.MandelbrotRepo;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;

@Path("Mandelbrot/getMandelbrot")
public class MandelbrotEndpoint {
    @Inject
    MandelbrotRepo repo;

    @GET
    @Produces("image/png")
    public Object getMandelbrot(){
        return Response.ok().entity(new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {

                output.write(repo.create());
                output.flush();
            }
        }).build();
    }
/*
    @GET
    public JsonArray getFachs(){
        return repo.getAll().stream()
                .map(c ->
                        Json.createObjectBuilder()
                                .add("name", c.getName())
                                .add("kommentar", c.getKommentar())
                                .build())
                .collect(Json::createArrayBuilder
                        , JsonArrayBuilder::add
                        , JsonArrayBuilder::add)
                .build();
    }
*/

}
