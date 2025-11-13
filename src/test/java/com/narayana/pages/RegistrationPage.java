package com.narayana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private By maleGenderRadio = By.id("gender-male");
    private By femaleGenderRadio = By.id("gender-female");
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By dayDropdown = By.name("DateOfBirthDay");
    private By monthDropdown = By.name("DateOfBirthMonth");
    private By yearDropdown = By.name("DateOfBirthYear");
    private By registerButton = By.id("register-button");
    private By successMessage = By.cssSelector("div.result");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Fill registration form and submit
    public void registerUser(String gender, String firstName, String lastName, 
                           String email, String password, String day, String month, String year) {
        if (gender.equalsIgnoreCase("male")) {
            clickElement(maleGenderRadio);
        } else {
            clickElement(femaleGenderRadio);
        }
        
        typeText(firstNameField, firstName);
        typeText(lastNameField, lastName);
        typeText(emailField, email);
        typeText(passwordField, password);
        typeText(confirmPasswordField, password);
        
        selectDropdownByVisibleText(dayDropdown, day);
        selectDropdownByVisibleText(monthDropdown, month);
        selectDropdownByVisibleText(yearDropdown, year);
        
        clickElement(registerButton);
    }

    public String getSuccessMessage() {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).getText();
    }
}
