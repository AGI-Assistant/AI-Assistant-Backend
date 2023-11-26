package ai.message;




import ai.client.AiModelClient;

import ai.dto.Content;
import ai.dto.Generate;
import ai.dto.History;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class MessageService {



    @Inject
    MessageRepository messageRepository;

    @Inject
    @RestClient
    AiModelClient aiModelClient;


    //Persist Messages

    public Message addMessage(Message message) {




       messageRepository.persist(message);
        //TODO check if it works with The AiModel
        //TODO uncomment to test it with the ai model
        Content response = requestAiModel(message.getText());

        //TODO implement messageID
       // Uncomment this to test it with the ai model
        Message aiResponse = new Message(response.getContent(), false, System.currentTimeMillis() / 1000L );
        messageRepository.persist(aiResponse);



        return aiResponse;

    }

    public List<Message> getAllMessagesByConvID(UUID conversationID) {

        return messageRepository.findMessagesByConversationID(conversationID.toString());
    }



    private Content requestAiModel(String prompt){

        return aiModelClient.generate(new Generate(prompt));
    }

    public History getHistory(UUID conversationID) {

        return new History(conversationID, messageRepository.findMessagesByConversationID(conversationID.toString()));
    }

    public List<History> startPolling() {

        List<History> histories = new ArrayList<>();
      messageRepository.findAll().list().forEach(message -> histories.add(new History(UUID.fromString(message.getConversationID()),
              messageRepository.findMessagesByConversationID(message.getConversationID()))));
        return histories;

    }



    public Message findPromptById(UUID id) {

        return messageRepository.findById(id);
    }
}
