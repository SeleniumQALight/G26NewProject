package loginTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class LoginTestWithOutPageObject {
    private WebDriver webDriver;

    @Before
    public void setup() {
    }

    @After
    public void teardown(){
    }

    @Test
    public void validLogOn() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua/login");
        System.out.println("Page was opened");
        webDriver.quit();
    }
}
