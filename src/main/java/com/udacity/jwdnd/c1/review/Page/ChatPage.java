package com.udacity.jwdnd.c1.review.Page;

import com.udacity.jwdnd.c1.review.Model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {
    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(id = "submitBtn")
    private WebElement messageSubmit;

    @FindBy(id = "chatUsername")
    private WebElement chatUsername;

    @FindBy(id = "chatMessage")
    private WebElement chatMessage;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendMessage(String text) {
        this.messageField.sendKeys(text);
        this.messageSubmit.click();
    }

    public ChatMessage getFirstMessage() {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessage(this.chatMessage.getText());
        chatMessage.setUsername(this.chatUsername.getText());
        return chatMessage;
    }
}
