package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class ValidLoginTest extends ParentTest {
    @Test
    public void validLogOn() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput("Student");
        logInPage.enterPassWordToInput("909090");
        logInPage.clickOnSubmitButton();
        checkAC("Avatar isn`t present on page", homePage.isAvatarPresent(), true);
    }
}
