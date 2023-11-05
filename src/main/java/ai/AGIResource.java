package ai;

import ai.dto.History;
import ai.message.Message;
import ai.message.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
if (messageService.startPolling().isEmpty()){
    return Response.noContent().build();
}

    return Response.ok(messageService.startPolling()).build();


}


    //TODO 201

    @Path("/post/message")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMessage(Message message) throws JsonProcessingException {

        message.setConversationID(uuid);
        System.out.println(message);
        messageService.addMessage(message);

        return Response.created(null).build();
    }



}
