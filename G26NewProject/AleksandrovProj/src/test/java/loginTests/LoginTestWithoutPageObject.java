package loginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Test class for webDriver first example
 * Created by andrey.aleksandrov on 13.07.2017.
 */
public class LoginTestWithoutPageObject {
    WebDriver webDriver;
    Actions action;

    @Test
    public void validLogOn() {
        //run chromedriver
        File fileFF = new File( ".././drivers/chromedriver.exe" );
        System.setProperty( "webdriver.chrome.driver", fileFF.getAbsolutePath() );
        webDriver = new ChromeDriver();
        action = new Actions( webDriver );
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );

        //go to website
        webDriver.get( "http://v3.qalight.com.ua/" );
        //login input
        WebElement loginField = webDriver.findElement( By.xpath( "//input[@name='_username']" ) );
        action.sendKeys( loginField, "student" ).build().perform();

        //password input
        WebElement passwordFiled = webDriver.findElement( By.xpath( "//input[@name='_password']" ) );
        action.sendKeys( passwordFiled, "909090" ).build().perform();

        //submit
        WebElement submitButton = webDriver.findElement( By.xpath( "//button[@type='submit']" ) );
        action.click( submitButton ).build().perform();

        //get username
        WebElement name = webDriver.findElement( By.xpath( "//div[contains(@class, 'pull-left info')]/p" ) );
        String username = name.getText();

        //check correct login
        String expectedName = "Студент";
        Assert.assertArrayEquals( new String[]{username}, new String[]{expectedName} );

        System.out.println( "Page was opened" );

        webDriver.quit();
    }
}