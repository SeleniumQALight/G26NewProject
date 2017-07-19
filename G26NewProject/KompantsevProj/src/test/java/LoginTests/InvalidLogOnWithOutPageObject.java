package LoginTests;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

public class InvalidLogOnWithOutPageObject extends ParentTest {

    public InvalidLogOnWithOutPageObject() {
    }

    @Test
    public void invalidLogOn() {

        logInPage.openLoginPage();
//        webDriver.get("http://v3.qalight.com.ua/");
        logInPage.enterLoginToInput("Student");
//        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//*[@id='password']")).sendKeys("2222");
        webDriver.findElement(By.xpath(".//button")).click();
        checkAC("Text 'Учет запчастей' not found", webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed(), true);
//        Assert.assertTrue(webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());
    }
}