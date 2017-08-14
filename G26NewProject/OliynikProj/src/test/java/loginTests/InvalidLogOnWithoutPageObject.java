package loginTests;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;


public class InvalidLogOnWithoutPageObject extends ParentTest {

    public InvalidLogOnWithoutPageObject() {

    }

    @Test
 //   @Ignore
    public void invalidLogOn() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput("student");
        logInPage.enterLoginToInput("2222");
        logInPage.clickOnSubmitButton();
        //alt+enter- sozdat metod v
//        Assert.assertTrue( webDriver.findElement( By.xpath( "//*[contains(text(),'Учет запчастей')]" ) ).isDisplayed() );
        checkAcceptanceCriteria( "Page 'Учет запчастей' not found",
              logInPage.isElementWithTextPresent("Учет запчастей"), true);

    }

}