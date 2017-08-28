package LoginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Оля on 17.07.2017.
 */
public class InvalidLogOnWithoutPageobject extends ParentTest {


    public InvalidLogOnWithoutPageobject(String browser) {
        super(browser);

    }

    @Test
    public void invalidLogOn(){
        loginPage.openLoginPage();
      //  webDriver.get("http://v3.qalight.com.ua/");
        loginPage.enterLoginToInput("Student");
      //  webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");
        loginPage.enterPasswordToInput("222");
        //   webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("222");
        loginPage.pressButtonSubmit();
       // webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        checkAC("Text 'Учет запчастей' not found",loginPage.isElementWithTextPresent("Учет запчастей"), true);
        // checkAC("Text 'Учет запчастей' not found", webDriver.findElement(By.xpath(".//a[@href='http://v3.qalight.com.ua/']")).isDisplayed(), true);
        //Assert.assertTrue("Assert work",webDriver.findElement(By.xpath(".//a[@href='http://v3.qalight.com.ua/']")).isDisplayed());
    }


}
