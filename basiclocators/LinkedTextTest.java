package com.fall23.basiclocators;

import com.fall23.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.fall23.WebDriverManager.openTheSite;

public class LinkedTextTest extends BaseTest {

@Test
    void test123()throws InterruptedException{
    openTheSite("https://demoqa.com/links");

    WebElement home = driver.findElement(By.linkText("Home"));
    home.click();
    Thread.sleep(5000);

}
}
