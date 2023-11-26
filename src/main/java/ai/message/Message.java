package ai.message;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import org.bson.codecs.pojo.annotations.BsonId;

import java.util.UUID;





public class Message extends PanacheMongoEntityBase {


    @BsonId
    private String conversationID;
    private Boolean isUser;
    private String text;


    private long timestamp;


    public Message( String textContent, Boolean isUser, long timestamp) {
        this.isUser = isUser;
        this.text = textContent;
        this.timestamp = timestamp;

    }

    public Message( String textContent, Boolean isUser, UUID conversationID) {
        this.isUser = isUser;
        this.text = textContent;
        this.conversationID = conversationID.toString();
        this.timestamp = System.currentTimeMillis() / 1000L;

    }





    public Message() {
        this.timestamp = System.currentTimeMillis() / 1000L;
    }

    public Boolean getIsUser() {
        return isUser;
    }

    public void setIsUser(Boolean isUser) {
        this.isUser = isUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String prompt) {
        this.text = prompt;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }




    public void setConversationID(UUID id) {
        this.conversationID = id.toString();
    }



    @Override
    public String toString() {
        return "Message{" +
                "isUser='" + isUser + '\'' +
                ", textContent='" + text + '\'' +
                '}';
    }

    public String getConversationID() {
        return this.conversationID;
    }
}
