package ai.message;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

@ApplicationScoped
public class MessageRepository implements PanacheMongoRepositoryBase<Message, String> {
    public Message findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void deleteById(UUID id) {
        delete("id", id);
    }


    public List<Message> findMessagesByConversationID(String conversationID) {
       return findAll().stream().filter(message -> message.getConversationID().equals(conversationID)).toList();
    }



}

// convo in SQL, Message in MongoDB