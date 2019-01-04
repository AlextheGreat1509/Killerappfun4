package restServer.services;

import com.google.gson.Gson;
import restServer.handler.ListHandler;
import restServer.reply.Reply;
import restServer.reply.Status;
import restServer.responseModels.SubmitResponse;
import restServer.responseModels.SubmitResultResponse;

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
            listHandler.SubmitEntry(submitResponse.getProblemWords(), submitResponse.getTranslationWords(), submitResponse.getTitle(), submitResponse.getProblemLanguage(), submitResponse.getTranslationLanguage(), submitResponse.getPersonEmail());
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
    public Response findListById(@DefaultValue("") @QueryParam("id") String id, @Context UriInfo uriInfo){

        Reply reply = new Reply(Status.OK, listHandler.GetListById(Integer.parseInt(id)));
        return Response.status(reply.getStatus().getCode())
                .entity(reply.getMessage()).build();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/getlistsbyemail")
    public Response findListsByEmail(@DefaultValue("") @QueryParam("email") String email, @Context UriInfo uriInfo){

        Reply reply = new Reply(Status.OK, listHandler.GetListsByEmail(email));
        return Response.status(reply.getStatus().getCode())
                .entity(reply.getMessage()).build();
    }

    @POST
    @Consumes("application/json")
    @Path("/submitresult")
    public Response submitResult(String data) {
        Gson gson = new Gson();
        Reply reply = null;
        SubmitResultResponse submitResultResponse = gson.fromJson(data, SubmitResultResponse.class);
        listHandler.SubmitResultEntry(submitResultResponse.getWordListId(), submitResultResponse.getScore(), submitResultResponse.getTotal(), submitResultResponse.getEmail());
        reply = new Reply(Status.OK, true);
        return Response.status(reply.getStatus().getCode())
                .entity(reply.getMessage()).build();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/getresultsbyemail")
    public Response findResultsByEmail(@DefaultValue("") @QueryParam("email") String email, @Context UriInfo uriInfo){

        Reply reply = new Reply(Status.OK, listHandler.GetResultsByEmail(email));
        return Response.status(reply.getStatus().getCode())
                .entity(reply.getMessage()).build();
    }

}
