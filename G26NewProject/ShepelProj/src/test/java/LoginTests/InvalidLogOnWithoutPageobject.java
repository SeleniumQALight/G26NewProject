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
 * Created by shepel_av on 17.07.2017.
 */
public class InvalidLogOnWithoutPageobject extends ParentTest{
    WebDriver webDriver;

    public InvalidLogOnWithoutPageobject(WebDriver webDriver) {
        super(webDriver);
    }

    @Test
    public void invalidLogOn() {
        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("student");
        webDriver.findElement(By.xpath(".//*[@name='_password']")).sendKeys("xxx");
        webDriver.findElement(By.xpath(".//button")).click();
        Assert.assertTrue("Assert is working",webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed()); // делаем проверку віведен ли на єкран текст

    }

}
