package com.example;

import com.example.message.Message;
import com.example.message.MessageService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/api")
public class AGIResource {

    @Inject
    MessageService promptService;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }


    @GET
    @Path("/get/history")
    @Produces(MediaType.TEXT_PLAIN)
    public String getChatHistory( @HeaderParam("conversationID") String conversationID) {



        return "functions";
    }

    @GET
    @Path("/get/polling")
    @Produces(MediaType.TEXT_PLAIN)
    public Response startPolling(@HeaderParam("conversationID") String conversationID) {



        return Response.noContent().build();
    }


    @Path("/post/message")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message sendMessage( Message message) {

        message.setConversationID(UUID.randomUUID());

        System.out.println(message);
        return promptService.addMessage(message);
    }



}
