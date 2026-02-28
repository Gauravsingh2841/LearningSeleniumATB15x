package com.thetestingacademy.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TTABank {

    @Test
    public void CheckTransferAmount() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
        driver.findElement(By.xpath("//input[@placeholder='John Doe']")).sendKeys("Gaurav");
        driver.findElement(By.xpath("//input[@placeholder='you@example.com']")).sendKeys("gauravzapak12@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Gaurav28");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Transfer Funds']")).click();
        driver.findElement(By.xpath("//input[@placeholder='0.00']")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@placeholder='e.g. Rent for October']")).sendKeys("Rent");
        driver.findElement(By.xpath("//button[text()='Continue']")).click();
        driver.findElement(By.xpath("//button[text()='Confirm Transfer']")).click();
        driver.findElement(By.xpath("//button[text()='Dashboard']")).click();
        WebElement totalBalance = driver.findElement(By.xpath("//h3[text()='45,000.00']"));
        Assert.assertEquals(totalBalance.getText(), "$45,000.00");
        driver.quit();
    }
}
