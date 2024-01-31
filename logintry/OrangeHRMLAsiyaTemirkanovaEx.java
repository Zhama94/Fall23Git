package com.fall23.logintry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMLAsiyaTemirkanovaEx {

    public WebDriver driver;
    @BeforeClass
    public void data(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test(description = "Login with valid username and valid password")
    void loginWithValidUsernameAndValidPasswordTest() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver-win64/chromedriver.exe");
//         driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String actualLoginText = driver.findElement(By.tagName("h5")).getText();
        String expectedLoginText = "Login";
        Assert.assertEquals(actualLoginText, expectedLoginText);

        String username = "Admin";
        String password = "admin123";

        WebElement usernameInputField = driver.findElement(By.name("username"));
        WebElement passwordInputField = driver.findElement(By.name("password"));

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.tagName("button"));
        loginBtn.click();

        String actualDashboardText = driver.findElement(By.tagName("h6")).getText();
        String expectedDashboardText = "Dashboard";
        Assert.assertEquals(actualDashboardText, expectedDashboardText);
    }
    @Test
    public void forgotYourPassword(){
        WebElement forgotPasswordBtn = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotPasswordBtn.click();
        String name = "John";

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(name);

        WebElement resetPassword = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        resetPassword.click();

    }
    @AfterTest
    public void clouseBrowser(){
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();

        }
        driver.close();
    }
}
