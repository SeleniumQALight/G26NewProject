package LoginTests;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RemoteTest {

    WebDriver webDriver;
    public Logger logger = Logger.getLogger(getClass());
    @Test
    public void invalidRemoteWebDriverLogon() throws MalformedURLException {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua");
        webDriver.findElement(By.xpath(".//*[@name='_username']"))
         .sendKeys("Student");
        webDriver.findElement(By.xpath(".//*[@id='password']"))
                .sendKeys("2222");
        checkAC("Text 'Учет запчастей' not found",
                webDriver.findElement(
                By.xpath(".//*[text()='Учет запчастей']")).isDisplayed()
                ,true
        );


    }

    private void checkAC(String s, boolean displayed, boolean b) {
        Assert.assertTrue(webDriver.findElement(
                 By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());
    }
@After
public void tearDown(){


     webDriver.quit();

}

}
