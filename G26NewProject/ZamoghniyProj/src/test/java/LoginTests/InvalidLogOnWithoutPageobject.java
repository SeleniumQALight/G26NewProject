package LoginTests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.ParentPages;
import parentTest.ParentTest;


/**
 * Created by Asus on 17.07.2017.
 */
public class InvalidLogOnWithoutPageobject extends ParentTest {


    public InvalidLogOnWithoutPageobject() {

    }

    @Test
    public void invalidLogOn(){

     loginPage.openLoginPage( );
       // webDriver.get("http://v3.qalight.com.ua");
        loginPage.enterLoginToInput("Student");
       // webDriver.findElement(By.xpath(".//*[@name='_username']"))
         //       .sendKeys("Student");
        loginPage.enterPasswordToInput("2222");
        //webDriver.findElement(By.xpath(".//*[@id='password']"))
               // .sendKeys("2222");
       loginPage.clickOnSubmitButton();
       // webDriver.findElement(By.xpath(".//button")).click();
        checkAC("Text 'Учет запчастей' not found",
                loginPage.isElementWithTextPresent("Учет запчастей")
                //webDriver.findElement(
               // By.xpath(".//*[text()='Учет запчастей']")).isDisplayed()
                ,true
        );
      //  Assert.assertTrue(webDriver.findElement(
          //      By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());



    }

}
