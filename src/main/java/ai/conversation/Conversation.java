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

    private String title;
    private String content;



    public Conversation(String title, String content){
        this.conversationID = UUID.randomUUID();
        this.title = title;
        this.content = content;

    }

    public Conversation() {
        this.conversationID = UUID.randomUUID();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String message) {
        this.content = message;
    }



    public UUID getConversationID() {
        return conversationID;
    }

    public void setConversationID(UUID id) {
        this.conversationID = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "username='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
