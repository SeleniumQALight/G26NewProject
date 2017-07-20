package LoginTests;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Created by tatyanavolkorezova on 17.07.17.
 */
public class InvalidLogOnWithoutPageobject extends ParentTest{

    public InvalidLogOnWithoutPageobject() {

    }

    @Test
    public void invalidLogOn(){

        logInPage.openLogInPage();
        logInPage.enterLogInToInput("Student");
       // webDriver.get("http://v3.qalight.com.ua/");
     //   webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("2222");
        webDriver.findElement(By.xpath(".//button")).click();
      checkAC("Text 'Учет запчастей' not found", webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed(), true);
       // Assert.assertTrue("Assert works",webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());

    }

}
