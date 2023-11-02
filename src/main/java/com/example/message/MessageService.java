package com.example.message;



import com.example.client.AiModelClient;
import com.example.dto.Content;
import com.example.dto.Generate;
import io.quarkus.hibernate.orm.panache.Panache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import java.util.UUID;

@ApplicationScoped
public class MessageService {



    @Inject
    MessageRepository messageRepository;

    @Inject
    @RestClient
    AiModelClient aiModelClient;


    //Persist Messages
    @Transactional
    public Message addMessage(Message message) {

        EntityManager entityManager = Panache.getEntityManager();

        //TODO check if it works with The AiModel
        //TODO uncomment to test it with the ai model
        Content response = requestAiModel(message.getTextContent());

        //TODO implement messageID
        //Uncomment this to test it with the ai model
        Message aiResponse = new Message(response.getContent(), false);
        entityManager.merge(aiResponse);

         entityManager.merge(message);
return aiResponse;

    }

    private Content requestAiModel(String prompt){

        return aiModelClient.generate(new Generate(prompt));
    }




    public Message findPromptById(UUID id) {

        return messageRepository.findById(id);
    }
}
