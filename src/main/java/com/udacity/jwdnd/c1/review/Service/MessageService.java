package com.udacity.jwdnd.c1.review.Service;

import com.udacity.jwdnd.c1.review.Mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.Model.ChatForm;
import com.udacity.jwdnd.c1.review.Model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public void addMessage(ChatForm chatform) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatform.getUsername());
        String newMessage = chatform.getMessage();
        switch (chatform.getMessageType()) {
            case "Shout":
                newMessage = upperCase(newMessage);
                break;
            case "Whisper":
                newMessage = lowerCase(newMessage);
                break;
            case "Say":
                newMessage = chatform.getMessage();
                break;
        }
        chatMessage.setMessage(newMessage);
        messageMapper.insert(chatMessage);
    }

    public List<ChatMessage> getMessages(String username) {
        return this.messageMapper.getMessages(username);
    }

    private String upperCase(String message) {
        return message.toUpperCase();
    }

    private String lowerCase(String message) {
        return message.toLowerCase();
    }
}
