package loginTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by tatyanavolkorezova on 13.07.17
 */
public class LoginTestWithOutPageObject {
    private WebDriver webDriver;



    @Test
    public void validLogOn(){

        File fileFF = new File("./macDrivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        //open browser
        webDriver= new ChromeDriver();
        //maximize window
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua/");

        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        webDriver.findElement(By.xpath(".//*[@class='dropdown-toggle']"));
        assert  webDriver.findElement(By.xpath(".//H1")).isDisplayed();
        assert webDriver.findElement(By.xpath(".//H3")).isDisplayed();
        //close vkladka, broweser is still opened
        //quit - close broweser
        webDriver.quit();
    }

    @Test
    public void invalidLogOn(){

        File fileFF = new File("./macDrivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        //open browser
        webDriver= new ChromeDriver();
        //maximize window
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua/");

        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("12345");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        assert webDriver.findElement(By.xpath(".//H1")).isDisplayed();

        webDriver.quit();

    }


}
