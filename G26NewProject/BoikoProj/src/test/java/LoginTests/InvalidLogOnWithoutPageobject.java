package LoginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Оля on 17.07.2017.
 */
public class InvalidLogOnWithoutPageobject extends ParentTest {


    public InvalidLogOnWithoutPageobject() {

    }

    @Test
    public void invalidLogOn(){
        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("222");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        Assert.assertTrue("Assert work",webDriver.findElement(By.xpath(".//a[@href='http://v3.qalight.com.ua/']")).isDisplayed());
    }


}
