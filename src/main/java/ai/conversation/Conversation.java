package ai.conversation;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.generator.BeforeExecutionGenerator;

import java.util.UUID;

@Entity
@Table(name = "conversations")
public class Conversation extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "uuid", type = BeforeExecutionGenerator.class)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID conversationID;
    private String name;
    private String summery;

    private UUID userID;



    public Conversation(String title, String content){
        this.conversationID = UUID.randomUUID();
        this.name = title;
        this.summery = content;

    }

    public Conversation() {
        this.conversationID = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String message) {
        this.summery = message;
    }



    public UUID getConversationID() {
        return conversationID;
    }

    public void setConversationID(UUID id) {
        this.conversationID = id;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID id) {
        this.userID = id;
    }


    @Override
    public String toString() {
        return "Message{" +
                "username='" + name + '\'' +
                ", content='" + summery + '\'' +
                '}';
    }
}
