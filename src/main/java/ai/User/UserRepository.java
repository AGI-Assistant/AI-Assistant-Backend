package ai.User;

import ai.conversation.Conversation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.UUID;

public class UserRepository implements PanacheRepository<User> {
    public User findById(UUID id) {
        return find("id", id).firstResult();
    }

    public void deleteById(UUID id) {
        delete("id", id);
    }

    public User findByName(String name){
        return find("name", name).firstResult();
    }

}





