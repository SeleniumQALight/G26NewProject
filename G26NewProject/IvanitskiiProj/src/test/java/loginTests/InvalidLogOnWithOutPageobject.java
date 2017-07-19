package loginTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import parentTest.ParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Leo on 17.07.2017.
 */
public class InvalidLogOnWithOutPageobject extends ParentTest {


    public InvalidLogOnWithOutPageobject()
    {
    }

    @Before
    public void setUp() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void invalidLogOn() {
        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//*[@name='_username']"))
                .sendKeys("Student");
        webDriver.findElement(By.xpath(".//*[@id='password']"))
                .sendKeys("pwd");
        webDriver.findElement(By.xpath(".//button")).click();
        Assert.assertTrue(webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
