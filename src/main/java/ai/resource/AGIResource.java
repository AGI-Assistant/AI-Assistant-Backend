package ai.resource;
import ai.model.Prompt;
import ai.service.PromptService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/ai")
public class AGIResource {

    @Inject
    PromptService promptService;


    // Gets a message by id
    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getPrompt(UUID id) {
        Prompt prompt = promptService.findPromptById(id);

        if (prompt != null) {
            return Response.ok(prompt).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UUID sendPrompt(Prompt prompt) {

        System.out.println(prompt);
        return promptService.addPrompt(prompt);
    }
}
