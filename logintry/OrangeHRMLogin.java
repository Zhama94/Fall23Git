package com.fall23.logintry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMLogin {

    @BeforeClass
        public WebDriver initializeDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return driver;
    }

    @Test (description = "loginWithInvalidUsernameAndInvalidPasswordTest", priority = 1)
    void loginWithInvalidUsernameAndInvalidPasswordTest() {
        WebDriver driver = initializeDriver();

        String actualLoginText = driver.findElement(By.tagName("h5")).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText,expectedLoginText);

        String invalidUsername = "invalid_username";
        String invalidPassword = "invalid_password";

        WebElement usernameInputField = driver.findElement(By.name("username"));
        WebElement passwordInputField = driver.findElement(By.name("password"));

        usernameInputField.sendKeys(invalidUsername);
        passwordInputField.sendKeys(invalidPassword);

        WebElement loginBtn= driver.findElement(By.tagName("button"));
        loginBtn.click();

        String actualErrorMessage = driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text")).getText();
        String expectedErrorMessage = "Invalid credentials";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

        driver.quit();
           }

    @Test (description = "loginWithValidUsernameAndValidPasswordTest", priority = 3)
    void loginWithValidUsernameAndValidPasswordTest() {
        WebDriver driver = initializeDriver();
        String actualLoginText = driver.findElement(By.tagName("h5")).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText,expectedLoginText);

        String username = "Admin";
        String password = "admin123";

        WebElement usernameInputField = driver.findElement(By.name("username"));
        WebElement passwordInputField = driver.findElement(By.name("password"));

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        WebElement loginBtn= driver.findElement(By.tagName("button"));
        loginBtn.click();

        String actualDashboardText = driver.findElement(By.tagName("h6")).getText();
        String expectedDashboardText = "Dashboard";
        Assert.assertEquals(actualDashboardText,expectedDashboardText);

        driver.quit();
    }
    @Test(description = "Message output 'Invalid credentials', if login incorrect", priority = 2)
    void incorrectPasswordMessageTest() {
        WebElement usernameInputField = initializeDriver().findElement(By.name("username"));
        WebElement passwordInputField = initializeDriver().findElement(By.name("password"));

        usernameInputField.sendKeys("admin");
        passwordInputField.sendKeys("1234");

        WebElement loginBtn = initializeDriver().findElement(By.tagName("button"));
        loginBtn.click();

        WebElement warningWindow = initializeDriver().findElement(By.className("oxd-text oxd-text--p oxd-alert-content-text"));

        String actualWarningText = warningWindow.getText();
        String expectedWarningText = "Invalid credentials";

        Assert.assertEquals(actualWarningText,expectedWarningText);

    }
    }
