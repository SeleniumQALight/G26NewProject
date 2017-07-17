package loginTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import parrentTest.ParrentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anya on 17.07.2017.
 */
public class InvalidLogOnWithoutPageObject extends ParrentTest{
    WebDriver webDriver;

    public InvalidLogOnWithoutPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    @Test
    public void invalidLogIn() {
        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student1");
        webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("9090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        Assert.assertTrue("Assert work", webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed());
    }
}
