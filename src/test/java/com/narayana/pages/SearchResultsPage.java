package com.narayana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private By productLink = By.xpath("//h2[@class='product-title']//a");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnProduct() {
        clickElement(productLink);
    }

    public boolean isProductDisplayed() {
        return isElementVisible(productLink);
    }
}
