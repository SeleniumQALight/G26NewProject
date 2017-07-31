package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;


public class ValidLogInTest extends ParentTest {
    @Test
    public void validLogOn(){
        logInPage.openLoginPage();
        logInPage.enterLoginToInput("Student");
        logInPage.enterPassWordToInput("909090");
        logInPage.clickOnSubmitButton();
        checkAC("Avatar is not present on Page",
                homePage.isAvatarPresent(),
                true);
    }
}