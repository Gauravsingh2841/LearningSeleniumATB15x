package com.thetestingacademy.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppVwoSeleniumWaitTask {
    @Test
    public void ExplicitWaitTask() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@admin.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@id='js-login-btn']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='js-notification-box-msg']")));
        String errorMessage = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']")).getText();
        Assert.assertEquals(errorMessage,"Your email, password, IP address or location did not match");

        driver.quit();
    }
}
