package com.example.message;



import io.quarkus.hibernate.orm.panache.Panache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


import java.util.UUID;

@ApplicationScoped
public class MessageService {



    @Inject
    MessageRepository messageRepository;


    //Persist Messages
    @Transactional
    public Message addMessage(Message message) {

        EntityManager entityManager = Panache.getEntityManager();

        //TODO check if it works with The AiModel
        //TODO uncomment to test it with the ai model


        //TODO implement messageID
        //Uncomment this to test it with the ai model



        return entityManager.merge(message);


    }





    public Message findPromptById(UUID id) {

        return messageRepository.findById(id);
    }
}
