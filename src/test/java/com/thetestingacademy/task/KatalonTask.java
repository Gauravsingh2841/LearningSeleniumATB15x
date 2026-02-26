package com.thetestingacademy.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KatalonTask {

    @Test
    public void Make_Appointment_Verification() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.name("password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(3000);
        WebElement appointmentTitle = driver.findElement(By.xpath("//h2[text()='Make Appointment']"));
        Assert.assertEquals(appointmentTitle.getText(), "Make Appointment");
        driver.quit();
    }
}
