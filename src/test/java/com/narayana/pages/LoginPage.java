package com.narayana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector("button.login-button");
    private By logoutLink = By.cssSelector("a.ico-logout");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Login with email and password
    public void login(String email, String password) {
        typeText(emailField, email);
        typeText(passwordField, password);
        clickElement(loginButton);
    }

    public boolean isLoggedIn() {
        return isElementVisible(logoutLink);
    }
}
