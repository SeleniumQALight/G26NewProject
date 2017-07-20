package LoginTest;

import org.junit.Test;
import org.openqa.selenium.By;
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

    @Test
    public void validLogOn()
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

    @Test
    public void invalidLogon()
    {
        File fileNN = new File( ".././drivers/chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", fileNN.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("http://v3.qalight.com.ua/");

        System.out.println("Page was opened");

        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("mmm");

        webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("111");

        webDriver.findElement(By.xpath(".//div[@class='col-xs-4']")).click();

        System.out.println("Enter invalid password and email");

        webDriver.findElement(By.xpath(".//img[@class='img-circle']"));

        System.out.println("Log in with incorrect password");


    }

    @Test
    public void validLogon()
    {
        File fileMM = new File(".././drivers/chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", fileMM.getAbsolutePath());

        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("http://v3.qalight.com.ua/");

        System.out.println("Page was opened");

        webDriver.findElement(By.xpath(".//*[@name='_username]")).sendKeys("Student");

        webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("909090");

        System.out.println("Enter valid Password and Email");

        webDriver.findElement(By.xpath(".//img[@class='img-circle']"));

        webDriver.quit();
    }

}
