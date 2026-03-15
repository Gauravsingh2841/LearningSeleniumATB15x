package com.thetestingacademy.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OrangeTableProject {

    @Test
    public void deleteFirstTerminatedEmployee() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        userName.sendKeys("admin");
        password.sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button")).click();
        //Thread.sleep(3000);
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-card']//div[contains(@class,'oxd-table-row')]"));
        for(WebElement row:rows){
            if(row.findElement(By.xpath(".//div[@role='cell'][6]")).getText().equals("Terminated")){
                row.findElement(By.xpath(".//div[@role='cell'][9]//div//button[1]")).click();
                break;
            }
        }
        driver.quit();
    }
}
