package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class JustForTesting {
    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  Older version Selenium 3(deprecated now in Selenium 4)
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.id("login-username")).sendKeys("gaurav@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("dahshsd");
        driver.findElement(By.id("js-login-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String message = wait.until(ExpectedConditions.elementToBeClickable(By.id("js-notification-box-msg"))).getText();
        Assert.assertEquals(message, "Your email, password, IP address or location did not match");
        Assert.assertTrue(true, "Your email, password, IP address or location did not match");
        System.out.println(message);
        System.out.println(message.contains("IP address or location did not match"));

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(message, "Yojur email, password, IP address or location did not match");

        driver.quit();
        soft.assertAll();
    }
}
