package com.fall23.basiclocators;

import com.fall23.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.fall23.WebDriverManager.openTheSite;

public class PartialLinkTextTest extends BaseTest {

    @Test
    void demo () throws InterruptedException {
        openTheSite("https://demoqa.com/links");
        WebElement Unauth = driver.findElement(By.linkText("Unauth"));
        Unauth.click();
        Thread.sleep(5000);
    }
}
