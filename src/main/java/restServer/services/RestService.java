package restServer.services;

import com.google.gson.Gson;
import restServer.reply.Reply;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/api")
    public class RestService {

        @POST
        @Consumes("application/json")
        @Path("/submit")
        public Response submit(String data) {
            Gson gson = new Gson();
            Reply reply = null;
            return Response.status(reply.getStatus().getCode())
                    .entity(reply.getMessage()).build();
        }

        @GET
        @Consumes(MediaType.TEXT_PLAIN)
        @Path("/get")
        public Response findList(@DefaultValue("") @QueryParam("equation") String equation, @Context UriInfo uriInfo){

            Reply reply = null;
            return Response.status(reply.getStatus().getCode())
                    .entity(reply.getMessage()).build();
        }

    }
