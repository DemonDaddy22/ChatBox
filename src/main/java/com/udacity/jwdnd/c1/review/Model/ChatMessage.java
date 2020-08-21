package com.udacity.jwdnd.c1.review.Model;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

public class ChatMessage {
    private String message, username;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
