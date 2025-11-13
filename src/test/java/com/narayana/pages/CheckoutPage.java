package com.narayana.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private By firstNameField = By.id("BillingNewAddress_FirstName");
    private By lastNameField = By.id("BillingNewAddress_LastName");
    private By emailField = By.id("BillingNewAddress_Email");
    private By countryDropdown = By.id("BillingNewAddress_CountryId");
    private By cityField = By.id("BillingNewAddress_City");
    private By address1Field = By.id("BillingNewAddress_Address1");
    private By zipField = By.id("BillingNewAddress_ZipPostalCode");
    private By phoneField = By.id("BillingNewAddress_PhoneNumber");
    
    private By continueBillingButton = By.xpath("//button[@onclick='Billing.save()']");
    private By continueShippingButton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
    private By continuePaymentMethodButton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
    private By continuePaymentInfoButton = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
    private By confirmButton = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
    
    private By successMessage = By.xpath("//div[@class='section order-completed']//div[@class='title']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // Fill all billing address form fields
    public void fillBillingAddress(String firstName, String lastName, String email, 
                                   String country, String city, String address, 
                                   String zip, String phone) {
        typeText(firstNameField, firstName);
        typeText(lastNameField, lastName);
        typeText(emailField, email);
        selectDropdownByVisibleText(countryDropdown, country);
        typeText(cityField, city);
        typeText(address1Field, address);
        typeText(zipField, zip);
        typeText(phoneField, phone);
    }

    public void clickContinueBillingAddress() {
        clickElement(continueBillingButton);
    }

    public void clickContinueShippingMethod() {
        clickElement(continueShippingButton);
    }

    public void clickContinuePaymentMethod() {
        clickElement(continuePaymentMethodButton);
    }

    public void clickContinuePaymentInfo() {
        clickElement(continuePaymentInfoButton);
    }

    public void clickConfirmOrder() {
        clickElement(confirmButton);
    }

    public String getOrderSuccessMessage() {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).getText();
    }
}
