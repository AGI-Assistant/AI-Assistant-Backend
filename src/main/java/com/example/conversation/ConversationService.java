package com.example.conversation;

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


    @Inject
    ConversationRepository conversationRepository;

    //Create a new Conversation
    @Transactional
    public UUID addConversation(Conversation conversation) {

        EntityManager entityManager = Panache.getEntityManager();
        entityManager.persist(conversation);

        Conversation persistedConversation = entityManager.find(Conversation.class, conversation.getConversationID());

        return persistedConversation.getConversationID();
    }


    //Search for a specific Conversation by its ID
    public Conversation findConversationByID(UUID id) {

        return conversationRepository.findById(id);
    }

    //Get all Messages filtered by ConversationID
    public List<Conversation> getAllMessagesByConvID(UUID conversationID) {

        //TODO not efficient, implement filtering
        List<Conversation> messages = conversationRepository.listAll();
        List<Conversation> conversation = new ArrayList<>();
        for (Conversation message : messages) {
            if (message.getConversationID().equals(conversationID)) {
                conversation.add(message);
            }
        }
        return conversation;
    }
}
