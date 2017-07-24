package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Created by zuzu on 7/17/2017.
 */
public class InvalidLogonWithoutPageObject extends ParentTest
        {


            public InvalidLogonWithoutPageObject()
            {

            }

            @Test
public void invalidLogOn()
        {
            logInPage.openLoginPage();
//            webDriver.get("http://v3.qalight.com.ua/");
            logInPage.enterLogInToInput("Student");
//            webDriver.findElement(By.xpath(".//input[@name='_username']"))
//                 .sendKeys("Student");
            logInPage.enterPasswordToInput("2222");
//            webDriver.findElement(By.xpath(".//input[@name='_password']"))
//                .sendKeys("000");
            logInPage.clickOnSubmitButton();
//            webDriver.findElement(By.xpath(".//div[@class='col-xs-4']")).click();
            checkAC("Text 'Учет запчастей' not found",
                    logInPage.isElementWithTextPresent ("Учет запчастей")
//                    webDriver.findElement
//                    (By.xpath(".//*[@text()=('Учет запчастей')]")).isDisplayed()
                    , true);
//            Assert.assertTrue("Assert work", webDriver.findElement
//                    (By.xpath(".//*[@text()=('Учет запчастей')]")).isDisplayed());
        }

        }
