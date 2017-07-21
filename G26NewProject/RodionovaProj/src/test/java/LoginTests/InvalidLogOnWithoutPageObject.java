package LoginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Unit test for simple App.
 */
public class InvalidLogOnWithoutPageObject extends ParentTest{

    public InvalidLogOnWithoutPageObject() {
    }

    @Test
    public void invalidLogOn(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswordToInput("909090");
        loginPage.clickOnSubmitButton();

       // webDriver.findElement(By.xpath(".//*[@name='_username']"))
        //        .sendKeys("Student");
      /*  webDriver.findElement(By.xpath(".//*[@id='password']"))
                .sendKeys("0000");*/
       // webDriver.findElement(By.xpath(".//button")).click();
        //Assert.assertTrue("Assert works!",webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());
        checkAC("Text 'Учет запчастей' not found",
                loginPage.isElementWithTextPresent("Учет запчастей"),true);
                /*webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed(),true);*/
    }


}
