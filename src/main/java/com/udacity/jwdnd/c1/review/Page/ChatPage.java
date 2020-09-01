package com.udacity.jwdnd.c1.review.Page;

import com.udacity.jwdnd.c1.review.Model.ChatMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatPage {
    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(className = "btn-success")
    private WebElement messageSubmit;

    @FindBy(className = "chatUsername")
    private WebElement chatUsername;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendMessage(String text) {
        this.messageField.sendKeys(text);
        this.messageSubmit.click();
    }

    public ChatMessage getFirstMessage(WebDriver driver) {
        ChatMessage chatMessage = new ChatMessage();

        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement displayedMessage = wait.until(driver1 -> driver1.findElement(By.className("chatMessage")));

        chatMessage.setMessage(displayedMessage.getText());
        chatMessage.setUsername(this.chatUsername.getText());
        return chatMessage;
    }
}
