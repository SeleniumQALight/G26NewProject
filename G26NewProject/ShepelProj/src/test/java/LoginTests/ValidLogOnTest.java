package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by shepel_av on 24.07.2017.
 */
public class ValidLogOnTest extends ParentTest {
    @Test
    public void validLogOn() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput("Student");
        logInPage.enterPassWordToInput("909090");
        logInPage.clickOnSubmitButton();
        checkAC("Avatar is not present on Page", homePage.isAvatarPresent(), true);
    }

}
