package ai.chat;

import ai.conversation.ConversationRepository;
import ai.message.Message;
import ai.message.MessageRepository;
import jakarta.inject.Inject;

public class ChatService {

    @Inject
    MessageRepository messageRepository;

    @Inject
    ConversationRepository conversationRepository;

    @Inject


    public void addMessage(Message message) {

        messageRepository.persist(message);
    }

}
