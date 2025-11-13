# Narayana Selection Test - E-Commerce & API Automation

This is an automation testing project that demonstrates both Selenium WebDriver for UI testing and REST Assured for API testing. The project follows the Page Object Model (POM) design pattern and uses TestNG as the testing framework.

## Prerequisites

- Java 21
- Maven 3.8.7
- Chrome browser installed

## Project Structure

```
Narayana-Selection-Test/
├── src/
│   ├── main/java/
│   └── test/java/
│       └── com/narayana/
│           ├── pages/        (Page Object Model classes)
│           └── tests/        (Test classes)
├── pom.xml
├── testng.xml
└── README.md
```

## Technologies Used

- Java 21
- Selenium WebDriver 4.15.0
- TestNG 7.8.0
- REST Assured 5.3.2
- WebDriverManager 5.6.2
- Maven

## Test Coverage

### ✅ API Testing (4 test cases)
Tests the JSONPlaceholder API (https://jsonplaceholder.typicode.com/):
- ✅ Create user with POST request
- ✅ Update user with PUT request
- ✅ Get user by ID (GET request)
- ✅ Get all users (GET request)

### 📝 UI Testing (4 test cases)
Tests the NopCommerce demo store (https://demo.nopcommerce.com/):
- User registration with TestNG DataProvider (2 users)
- User login and product search  
- Menu navigation using Actions class (hover and click)
- Complete checkout flow (register, add to cart, checkout)

**The framework demonstrates:**
- Explicit waits (WebDriverWait)
- TestNG DataProvider
- Actions class for menu interactions
- Complete end-to-end test flow design

## How to Run Tests

### Clone the repository
```bash
git clone https://github.com/Ap13ayush/Narayana-Selection-Test.git
cd Narayana-Selection-Test
```

### Run API tests (Recommended)
```bash
mvn test -Dtest=ApiTests
```

### Run UI tests (Requires graphical environment)
```bash
mvn test -Dtest=UiTests
```

### Run all tests
```bash
mvn clean test
```

## Features

- Page Object Model (POM) design pattern
- TestNG annotations and groups
- DataProvider for data-driven testing
- Explicit waits (WebDriverWait) - no Thread.sleep()
- Actions class for menu hover interactions
- REST Assured for API testing
- WebDriverManager for automatic browser driver management
