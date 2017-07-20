package LoginTest;


import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import parentTest.ParentTest;


import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Oleg on 17.07.2017.
 */
public class InvalidLogOnWithoutPageObject extends ParentTest {

    public InvalidLogOnWithoutPageObject() {
    }


    @Test
    public void invalidLogOn() {
        loginPage.openLoginPage();
       // webDriver.get("http://v3.qalight.com.ua/");
        loginPage.enterLoginToInput("Student");
     //   webDriver.findElement(By.xpath(".//*[@name = '_username']")).sendKeys("Student");
        loginPage.enterPasswToInput("2222");
     //   webDriver.findElement(By.xpath(".//*[@id = 'password']")).sendKeys("2222");
        loginPage.clickOnSubmitButton();
     //   webDriver.findElement(By.xpath(".//button")).click();
       // Assert.assertTrue("ERROR", webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());
        checkAC("text'учет запчастей' not found)", loginPage.isElementWithTextPresent("Учет запчастей")
       //         webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed()
                , true);
    }
}

