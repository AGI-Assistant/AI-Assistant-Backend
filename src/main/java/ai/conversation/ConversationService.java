package ai.conversation;

import ai.message.Message;
import ai.message.MessageService;
import io.quarkus.hibernate.orm.panache.Panache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ConversationService {
    MessageService messageService;


    @Inject
    ConversationRepository conversationRepository;

    //Create a new Conversation
    @Transactional
    public UUID addConversation(Conversation conversation) {


        conversationRepository.persist(conversation);

        Conversation persistedConversation = findConversationByID(conversation.getConversationID());

        return persistedConversation.getConversationID();
    }


    //Search for a specific Conversation by its ID
    public Conversation findConversationByID(UUID id) {

        return conversationRepository.findById(id);
    }

    //Get all Messages filtered by ConversationID
    public List<Message> getAllMessagesByConvID(UUID conversationID) {

        return messageService.getAllMessagesByConvID(conversationID);
    }
}
