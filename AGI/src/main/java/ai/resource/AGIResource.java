package ai.resource;

import ai.model.Prompt;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/ai")
public class AGIResource {


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAnswer() {
        return "Who are you?";
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String sendPrompt(Prompt prompt) {
        //Do some processing via AI Model API calls

        return "This is your answer based on your prompt "+prompt.getUsername()+"!\n"+prompt;
    }
}
