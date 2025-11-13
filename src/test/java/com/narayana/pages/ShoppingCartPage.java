package com.narayana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    private By termsCheckbox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void agreeToTermsOfService() {
        clickElement(termsCheckbox);
    }

    public void clickCheckoutButton() {
        clickElement(checkoutButton);
    }
}
