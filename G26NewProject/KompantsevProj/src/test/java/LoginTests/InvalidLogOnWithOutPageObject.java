package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class InvalidLogOnWithOutPageObject extends ParentTest {

    public InvalidLogOnWithOutPageObject() {
    }

    @Test
    public void invalidLogOn() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput("Student");
        logInPage.enterPassWordToInput("2222");
        logInPage.clickOnSubmitButton();
        checkAC("Text 'Учет запчастей' not found", logInPage.isElementWithTextPresent("Учет запчастей"), true);
    }
}