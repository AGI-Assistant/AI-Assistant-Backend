package ai.resource;


import ai.dto.Generate;
import ai.message.Message;
import ai.message.MessageService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class AGIResource {

    @Inject
    MessageService promptService;

    //Sends a message to the server and recives an answer.
    @Path("/chat")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message sendMessage(@HeaderParam("apiKey") String apiKey, @HeaderParam("conversationID") String conversationID, Message message) {

        System.out.println(apiKey+conversationID);
        System.out.println(message);
        return promptService.addMessage(message);
    }

    //Request the conversation history from the server.
    //TODO: Model has to send back the conversationID
    //TODO: Implement logic
    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHistory(@HeaderParam("apiKey") String apiKey, @HeaderParam("conversationID") String conversationID, Generate generate) {

        System.out.println(apiKey+conversationID);
        System.out.println(generate);
        return "functions";
    }



}
