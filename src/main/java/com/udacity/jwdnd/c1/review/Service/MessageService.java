package com.udacity.jwdnd.c1.review.Service;

import com.udacity.jwdnd.c1.review.Model.ChatForm;
import com.udacity.jwdnd.c1.review.Model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> messages;

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
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
        this.messages.add(chatMessage);
    }

    public List<ChatMessage> getMessages() {
        return this.messages;
    }

    private String upperCase(String message) {
        return message.toUpperCase();
    }

    private String lowerCase(String message) {
        return message.toLowerCase();
    }


}
