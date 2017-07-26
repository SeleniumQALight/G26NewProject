package loginTests;


//import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;



public class InvalidLogOnWithOutPageobject extends ParentTest {


    public InvalidLogOnWithOutPageobject()
    {
    }


    @Test
    public void invalidLogOn() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput("Student");
        logInPage.enterpassWordToInput("090909");
        logInPage.clickOnSubmitButtton();
        checkAC("Text 'Учет запчастей' not found",
                logInPage.isElementWithTextPresent("Учет запчастей")
//                webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed()
                , true);
//        webDriver.get("http://v3.qalight.com.ua/");
//        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
//        webDriver.findElement(By.xpath(".//*[@id='password']")).sendKeys("pwd");
//        webDriver.findElement(By.xpath(".//button")).click();
//        Assert.assertTrue(webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed());
    }

}
