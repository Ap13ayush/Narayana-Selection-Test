package com.narayana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

    private By computersMenu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
    private By notebooksSubmenu = By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Notebooks')]");
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.cssSelector("button.search-box-button");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Hover over Computers menu using Actions class
    public void hoverOnComputersMenu() {
        WebElement menu = driver.findElement(computersMenu);
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
    }

    public void clickNotebooksSubmenu() {
        clickElement(notebooksSubmenu);
    }

    // Search for a product
    public void searchProduct(String productName) {
        typeText(searchBox, productName);
        clickElement(searchButton);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
