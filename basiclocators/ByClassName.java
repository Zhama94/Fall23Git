package com.fall23.basiclocators;

import com.fall23.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.fall23.WebDriverManager.openTheSite;

public class ByClassName extends BaseTest {

    @Test
    void byClassNameTest(){
        openTheSite("https://demoqa.com/text-box");
        WebElement submitBtn = driver.findElement(By.className("btn btn-primary"));

        WebElement usernameInput = driver.findElement(By.id("userName"));
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));
        WebElement submitBtn2 = driver.findElement(By.className("btn btn-primary"));

        usernameInput.sendKeys("John");
        emailInput.sendKeys("john@gmail.com");
        currentAddressInput.sendKeys("WallStreet 555");
        permanentAddressInput.sendKeys("Sovet 123");
        submitBtn2.click();
    }
}
