package ai;

import ai.dto.History;
import ai.message.Message;
import ai.message.MessageService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/api")
public class AGIResource {

    //TODO: Only for testing purpose
    private final UUID uuid = UUID.randomUUID();

    @Inject
    MessageService messageService;



    @GET
    @Path("/get/history")
    @Produces(MediaType.TEXT_PLAIN)
    public History getChatHistory(@HeaderParam("conversationID") String conversationID) {



        return messageService.getHistory(uuid);
    }

    //TODO: Need a way to know which messages are new. Timestamp send from the last message the frontend has read?
    @GET
    @Path("/get/polling")
    @Produces(MediaType.TEXT_PLAIN)
    public Response startPolling() {
try {
    return Response.ok(messageService.startPolling()).build();
}
catch (Exception e){
    return Response.noContent().build();
}
}


    //TODO 201

    @Path("/post/message")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMessage(Message message) {

        message.setConversationID(uuid);

        messageService.addMessage(message);

        return Response.created(null).build();
    }



}
