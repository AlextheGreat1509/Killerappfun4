package restServer.services;

import com.google.gson.Gson;
import restServer.handler.ListHandler;
import restServer.reply.Reply;
import restServer.reply.Status;
import restServer.responseModels.SubmitResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/api")
    public class RestService {

    ListHandler listHandler = new ListHandler();

        @POST
        @Consumes("application/json")
        @Path("/submit")
        public Response submit(String data) {
            Gson gson = new Gson();
            Reply reply = null;
            SubmitResponse submitResponse = gson.fromJson(data, SubmitResponse.class);
            listHandler.SubmitEntry(submitResponse.getProblemWords(), submitResponse.getTranslationWords(), submitResponse.getTitle());
            reply = new Reply(Status.OK, true);
            return Response.status(reply.getStatus().getCode())
                    .entity(reply.getMessage()).build();
        }

        @GET
        @Path("/getlists")
        public Response findLists(){
            Reply reply = new Reply(Status.OK, listHandler.GetLists());
            return Response.status(reply.getStatus().getCode())
                    .entity(reply.getMessage()).build();
        }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/getlistbyid")
    public Response findEquation(@DefaultValue("") @QueryParam("id") String id, @Context UriInfo uriInfo){

        Reply reply = new Reply(Status.OK, listHandler.GetListById(Integer.parseInt(id)));
        return Response.status(reply.getStatus().getCode())
                .entity(reply.getMessage()).build();
    }

    }
