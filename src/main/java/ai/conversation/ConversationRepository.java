package ai.conversation;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ConversationRepository implements PanacheRepository<Conversation> {
    public Conversation findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void deleteById(UUID id) {
        delete("id", id);
    }

    public Conversation findByName(String name){
        return find("name", name).firstResult();
    }




}
