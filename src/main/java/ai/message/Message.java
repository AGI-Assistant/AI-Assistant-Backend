package ai.message;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.generator.BeforeExecutionGenerator;

import java.util.UUID;

@Entity
@Table(name = "messages")
public class Message extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "uuid", type = BeforeExecutionGenerator.class)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID messageID;
    private UUID conversationID;
    private Boolean isUser;
    private String textContent;

    @Column(name = "timestamp", updatable = false, nullable = false)
    private long timestamp;


    public Message( String textContent, Boolean isUser, long timestamp) {
        this.messageID = UUID.randomUUID();
        this.isUser = isUser;
        this.textContent = textContent;
        this.timestamp = timestamp;

    }

    public Message( String textContent, Boolean isUser, UUID conversationID) {
        this.messageID = UUID.randomUUID();
        this.isUser = isUser;
        this.textContent = textContent;
        this.conversationID = conversationID;
        this.timestamp = System.currentTimeMillis() / 1000L;

    }





    public Message() {
        this.messageID = UUID.randomUUID();
        this.timestamp = System.currentTimeMillis() / 1000L;
    }

    public Boolean getIsUser() {
        return isUser;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String prompt) {
        this.textContent = prompt;
    }

    public long getTimestamp() {
        return timestamp;
    }



    public UUID getMessageID() {
        return messageID;
    }

    public void setMessageID(UUID id) {
        this.messageID = id;
    }

    public void setConversationID(UUID id) {
        this.conversationID = id;
    }



    @Override
    public String toString() {
        return "Prompt{" +
                "isUser='" + isUser + '\'' +
                ", prompt='" + textContent + '\'' +
                '}';
    }

    public UUID getConversationID() {
        return this.conversationID;
    }
}
