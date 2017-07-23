package LoginTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import parentTest.ParentTest;

/**
 * Created by shepel_av on 17.07.2017.
 */
public class InvalidLogOnWithoutPageobject extends ParentTest{
    WebDriver webDriver;

    public InvalidLogOnWithoutPageobject(WebDriver webDriver) {
        super(webDriver);
    }

    @Test
    public void invalidLogOn() {
        logInPage.openLoginPage();
//        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        logInPage.enterPasswordToInput("2222");
//        webDriver.findElement(By.xpath(".//*[@name='_password']")).sendKeys("2222");
        logInPage.clickOnSubmitButton();
//        webDriver.findElement(By.xpath(".//button")).click();
//        Assert.assertTrue("Assert is working",webDriver.findElement(
//                By.xpath(".//*[text()='Учет запчастей']")).isDisplayed()); // делаем проверку віведен ли на єкран текст
        checkAC("Text 'Учет запчастей' not found"),
                logInPage.isElementWithTextPresent("Учет запчастей"),
                true);

    }

}
