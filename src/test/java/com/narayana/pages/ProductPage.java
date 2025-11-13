package com.narayana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private By addToCartButton = By.id("add-to-cart-button-4");
    private By successBar = By.cssSelector("div.bar-notification.success");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        clickElement(addToCartButton);
    }

    // Wait for success message using explicit wait
    public void waitForSuccessMessage() {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(successBar));
    }

    public String getSuccessMessage() {
        return driver.findElement(successBar).getText();
    }
}
