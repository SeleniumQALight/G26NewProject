package LoginTests;


import org.apache.xpath.SourceTree;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTestWithOutPageObject {
    WebDriver webDriver;

    @Test
    public void validLogOn(){
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        System.out.println("Page was opened");
        webDriver.quit();
    }

    @Test
    public void invalidLogOn(){
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        System.out.println("Page was not opened");
        webDriver.quit();
    }

    @Test
    public void LogOutFromProfile(){
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        webDriver.findElement(By.xpath(".//span[@class='hidden-xs']")).click();
        webDriver.findElement(By.xpath(".//a[@href='/logout']")).click();
        System.out.println("Login page is displayed");
        webDriver.quit();
    }
}
