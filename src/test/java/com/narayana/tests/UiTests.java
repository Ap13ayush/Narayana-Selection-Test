package com.narayana.tests;

import com.narayana.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

// Test class for NopCommerce UI automation
public class UiTests {

    WebDriver driver;
    
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Provides test data for registration
    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][] {
            {"Male", "Ayush", "Patel", "ayush.patel" + System.currentTimeMillis() + "@test.com", "Test@123", "12", "April", "2000"},
            {"Female", "Harshita", "Pal", "harshita.pal" + System.currentTimeMillis() + "@test.com", "Test@123", "12", "March", "2005"}
        };
    }

    // Test user registration with different user data
    @Test(groups = "UI", dataProvider = "userData")
    public void testUserRegistration(String gender, String firstName, String lastName, 
                                     String email, String password, String day, String month, String year) {
        driver.get("https://demo.nopcommerce.com/register");
        
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(gender, firstName, lastName, email, password, day, month, year);
        
        String successMsg = registrationPage.getSuccessMessage();
        Assert.assertEquals(successMsg, "Your registration completed");
    }

    // Test user login and product search functionality
    @Test(groups = "UI")
    public void testLoginAndSearch() {
        driver.get("https://demo.nopcommerce.com/login");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ayush.patel@test.com", "Test@123");
        
        Assert.assertTrue(loginPage.isLoggedIn());
        
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Apple MacBook Pro 13-inch");
        
        SearchResultsPage searchPage = new SearchResultsPage(driver);
        Assert.assertTrue(searchPage.isProductDisplayed());
        searchPage.clickOnProduct();
        
        Assert.assertTrue(driver.getTitle().contains("Apple MacBook Pro 13-inch"));
    }

    // Test menu navigation using Actions class for hover
    @Test(groups = "UI")
    public void testMenuNavigation() {
        HomePage homePage = new HomePage(driver);
        homePage.hoverOnComputersMenu();
        homePage.clickNotebooksSubmenu();
        
        Assert.assertTrue(homePage.getPageTitle().contains("Notebooks"));
    }

    // Test complete add to cart and checkout process
    @Test(groups = "UI")
    public void testCompleteCheckoutFlow() {
        driver.get("https://demo.nopcommerce.com/register");
        
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String email = "ayush.checkout" + System.currentTimeMillis() + "@test.com";
        registrationPage.registerUser("Male", "Ayush", "Patel", email, "Test@123", "12", "April", "2000");
        
        driver.get("https://demo.nopcommerce.com/computers/notebooks");
        
        SearchResultsPage searchPage = new SearchResultsPage(driver);
        searchPage.clickOnProduct();
        
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart();
        productPage.waitForSuccessMessage();
        
        String successMsg = productPage.getSuccessMessage();
        Assert.assertTrue(successMsg.contains("The product has been added to your shopping cart"));
        
        driver.get("https://demo.nopcommerce.com/cart");
        
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.agreeToTermsOfService();
        cartPage.clickCheckoutButton();
        
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillBillingAddress("Ayush", "Patel", email, "United States", 
                                       "New York", "123 Main St", "10001", "1234567890");
        checkoutPage.clickContinueBillingAddress();
        checkoutPage.clickContinueShippingMethod();
        checkoutPage.clickContinuePaymentMethod();
        checkoutPage.clickContinuePaymentInfo();
        checkoutPage.clickConfirmOrder();
        
        String orderSuccessMsg = checkoutPage.getOrderSuccessMessage();
        Assert.assertEquals(orderSuccessMsg, "Your order has been successfully processed!");
    }
}
