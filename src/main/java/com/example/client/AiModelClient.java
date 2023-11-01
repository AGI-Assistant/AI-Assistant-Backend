package com.example.client;






import com.example.dto.Content;
import com.example.dto.Generate;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


//Requests the Al model to generate content
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@ClientHeaderParam(name = "backendKey", value = "constant-header-value")
@ApplicationScoped
@Path("/api/generate")
@RegisterRestClient
public interface AiModelClient {

    @POST
    Content generate(Generate content);
}
