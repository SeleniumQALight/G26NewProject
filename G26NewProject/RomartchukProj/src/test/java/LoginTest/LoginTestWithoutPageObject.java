package LoginTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class LoginTestWithoutPageObject {
    WebDriver webDriver;

    // before and after start on each @test
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    @Test
    public void invalidLoon() {

    }

    @Test
    public void validLogOn() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua/");
        System.out.println("Page was opened");
        webDriver.quit();

    }
}
