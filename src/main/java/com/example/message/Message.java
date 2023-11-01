package com.example.message;

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


    public Message( String textContent, Boolean isUser) {
        this.messageID = UUID.randomUUID();
        this.isUser = isUser;
        this.textContent = textContent;

    }

    public Message( String textContent, Boolean isUser, UUID conversationID) {
        this.messageID = UUID.randomUUID();
        this.isUser = isUser;
        this.textContent = textContent;
        this.conversationID = conversationID;

    }





    public Message() {
        this.messageID = UUID.randomUUID();
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
