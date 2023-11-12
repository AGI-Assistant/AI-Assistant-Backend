package ai.dto;

import ai.message.Message;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


import java.util.List;
import java.util.UUID;


public class History extends PanacheEntityBase {


    private UUID conversationID;

   private List<Message> messages;



    public History(UUID conversationID, List<Message> messages){
        this.conversationID = conversationID;
        this.messages = messages;
    }

    public History() {

    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }





    public UUID getConversationID() {
        return conversationID;
    }

    public void setConversationID(UUID id) {
        this.conversationID = id;
    }

    @Override
    public String toString() {
        return "History{" +
                "conversationID=" + conversationID +
                ", messages=" + messages +
                '}';
    }
}

