package ai.message;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class MessageRepository implements PanacheRepository<Message> {
    public Message findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void deleteById(UUID id) {
        delete("id", id);
    }


    public List<Message> findMessagesByConversationID(UUID conversationID) {
        return find("conversationID", conversationID).list();
    }
}

// convo in SQL, Message in MongoDB