package loginTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by zuzu on 7/13/2017.
 */
public class LoginTestWithoutPageObject
{
    private WebDriver webDriver;

    @Before
    public void setup()
    {

    }



    @Test
    public void validLogon()
    {
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
