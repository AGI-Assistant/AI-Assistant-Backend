package com.example;

import com.example.dto.Generate;
import com.example.message.Message;
import com.example.message.MessageService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

@Path("/hello")
public class ExampleResource {

    @Inject
    MessageService promptService;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }


    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHistory(@HeaderParam("apiKey") String apiKey, @HeaderParam("conversationID") String conversationID) {

        System.out.println(apiKey+conversationID);

        return "functions";
    }


    @Path("/chat")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message sendMessage(@HeaderParam("apiKey") String apiKey, @HeaderParam("conversationID") String conversationID, Message message) {

        message.setConversationID(UUID.fromString(conversationID));
        System.out.println(apiKey+conversationID);
        System.out.println(message);
        return promptService.addMessage(message);
    }

}
