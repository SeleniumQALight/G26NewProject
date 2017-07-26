package LoginTests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;


public class InvalidLogOnWithoutPageobject extends ParentTest{

    public InvalidLogOnWithoutPageobject()  {   }

    @Test
    public void invalidLogOn(){

        logInPage.openLoginPage();
//        webDriver.get("http://v3.qalight.com.ua/");
        logInPage.enterLoginToInput("Student");
//        webDriver.findElement(By.xpath(".//*[@name='_username']"))
//                .sendKeys("Student");
        logInPage.enterPassWordToInput("2222");
//        webDriver.findElement(By.xpath(".//*[@id='password']"))
//                .sendKeys("2222");
        logInPage.clickOnSubmitButton();
//        webDriver.findElement(By.xpath(".//button")).click();
        checkAC("Text 'Учет запчастей' not found",
                logInPage.isElementWithTextPresent("Учет запчастей")
//                webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']"))
//                        .isDisplayed()
                ,true
        );
//        Assert.assertTrue("Assert work",webDriver.findElement(
//                By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());
    }

}
