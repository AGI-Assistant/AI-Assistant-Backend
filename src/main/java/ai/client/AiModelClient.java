package ai.client;







import ai.dto.Content;
import ai.dto.Generate;
import ai.message.Message;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
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
