package LoginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import parentTest.ParentTest;

/**
 * Created by Kleine-Hexe on 17.07.2017.
 */
public class InvalidLogOnWithoutPageObject extends ParentTest {

    public InvalidLogOnWithoutPageObject() {

    }

    @Test
    public void invalidLogOn() {
        loginPage.openLoginPage();
      //  webDriver.get("http://v3.qalight.com.ua/");
        loginPage.enterLoginToInput("Student");
      //  webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("222");
        webDriver.findElement(By.xpath(".//button")).click();
        //Assert.assertTrue(webDriver.findElement(By.xpath(".//*[@class='login-box-body']")).isDisplayed());
        // Assert.assertTrue(!webDriver.findElement(By.xpath(".//a[@class='dropdown-toggle']")).isDisplayed());
        checkAC("Text 'Учет запчастей' not found", webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed(),
                true);
        /*Assert.assertTrue("Assert work", webDriver.findElement(
                By.xpath(".//*[text()='Учет запчастей']")
        ).isDisplayed());*/

    }

}
