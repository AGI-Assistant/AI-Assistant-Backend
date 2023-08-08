package ai.resource;

import ai.model.Prompt;
import ai.service.PromptService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

@Path("/ai")
public class AGIResource {

    @Inject
    PromptService promptService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UUID sendPrompt(Prompt prompt) {

        System.out.println(prompt);
        return promptService.addPrompt(prompt);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prompt getPrompt(UUID id) {

        System.out.println(id);
        return promptService.findPromptById(id);
    }



}
