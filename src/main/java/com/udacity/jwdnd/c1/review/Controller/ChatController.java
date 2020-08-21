package com.udacity.jwdnd.c1.review.Controller;

import com.udacity.jwdnd.c1.review.Model.ChatForm;
import com.udacity.jwdnd.c1.review.Service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChats(@ModelAttribute("newChat") ChatForm chatForm, Model model) {
        chatForm.setMessage("");
        chatForm.setUsername("");
        model.addAttribute("chatMessages", this.messageService.getMessages());
        return "chat";
    }

    @PostMapping
    public String postChats(@ModelAttribute("newChat") ChatForm chatForm, Model model) {
        if (!chatForm.getMessage().equals("")) this.messageService.addMessage(chatForm);
        chatForm.setMessage("");
        chatForm.setUsername("");
        model.addAttribute("chatMessages", this.messageService.getMessages());
        return "chat";
    }

    @ModelAttribute("messageTypes")
    public String[] messageTypes() { return new String[]{"Say", "Shout", "Whisper"}; };
}
