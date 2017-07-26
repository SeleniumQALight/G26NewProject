package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by tatyanavolkorezova on 24.07.17.
 */
public class ValidLogOnTest extends ParentTest {

    @Test
    public void validLogOnTest(){
        logInPage.openLogInPage();
        logInPage.enterLogInToInput("Student");
        logInPage.enterPassWordToInput("909090");
        logInPage.clickOnSubmitButton();
        checkAC("Avatar is not present on Page", homePage.isAvatarPresent(), true);
    }
}
