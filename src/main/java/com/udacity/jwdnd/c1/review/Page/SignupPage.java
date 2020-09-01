package com.udacity.jwdnd.c1.review.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    @FindBy(id = "inputFirstName")
    private WebElement firstNameField;

    @FindBy(id = "inputLastName")
    private WebElement lastNameField;

    @FindBy(id = "inputUsername")
    private WebElement usernameField;

    @FindBy(id = "inputPassword")
    private WebElement passwordField;

    @FindBy(id = "submit-button")
    private WebElement registerBtn;

    @FindBy(id = "login-link")
    private WebElement loginRedirect;

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void registerUser(String fname, String lname, String username, String password) {
        this.firstNameField.sendKeys(fname);
        this.lastNameField.sendKeys(lname);
        this.usernameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.registerBtn.click();
    }
}
