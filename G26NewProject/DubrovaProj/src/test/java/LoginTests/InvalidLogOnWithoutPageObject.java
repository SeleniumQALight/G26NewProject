package LoginTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import parentTest.ParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kleine-Hexe on 17.07.2017.
 */
public class InvalidLogOnWithoutPageObject extends ParentTest{
    WebDriver webDriver;

    public InvalidLogOnWithoutPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    @Test
    public void invalidLogOn(){
        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("222");
        webDriver.findElement(By.xpath(".//button")).click();
        Assert.assertTrue(webDriver.findElement(By.xpath(".//*[@class='login-box-body']")).isDisplayed());
       // Assert.assertTrue(!webDriver.findElement(By.xpath(".//a[@class='dropdown-toggle']")).isDisplayed());



    }

}
