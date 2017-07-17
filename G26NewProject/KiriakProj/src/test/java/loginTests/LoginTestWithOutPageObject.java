package loginTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anya on 16.07.2017.
 */
public class LoginTestWithOutPageObject {
    WebDriver webDriver;

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

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

    @Test
    public void validLogIn() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua/");

        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("9090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        System.out.println("Login to Qalight.");
        webDriver.quit();
    }

    @Test
    public void invalidLogIn() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua/");

        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student1");
        webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("9090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        System.out.println("Invalid data. Doesn't login to Qalight.");
        webDriver.quit();
    }


}
