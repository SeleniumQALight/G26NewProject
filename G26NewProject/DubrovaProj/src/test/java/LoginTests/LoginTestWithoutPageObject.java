package LoginTests;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTestWithoutPageObject {
    WebDriver webDriver;

   /* @Before   - это аннотация для пре-кондишнз
    public void setUp(){};*/

   /*@After - это уже пост-кондишнз
   public void tearDown(){};*/

   // @Before @After пишутся вверху один раз, но при этом они будут выполняться для каждого последующего теста
    @Test
    public void validLogOn(){
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//div[@class='col-xs-4']//button[@type='submit']")).click();
        webDriver.findElement(By.xpath(".//a[@class='dropdown-toggle']"));
        System.out.println("Page  was opened");

        webDriver.quit();

    }
    @Test
    public void invalidLogOn(){
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("1");
        webDriver.findElement(By.xpath(".//div[@class='col-xs-4']//button[@type='submit']")).click();
        webDriver.findElement(By.xpath(".//*[@class='login-box-body']"));
        System.out.println("Login is not successful");

        webDriver.quit();

    }



}
