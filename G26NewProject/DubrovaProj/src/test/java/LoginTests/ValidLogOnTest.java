package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Kleine-Hexe on 24.07.2017.
 */
public class ValidLogOnTest extends ParentTest {

    @Test
    public void validLogOn(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswordToInput("909090");
        loginPage.clickOnSubmitButton();
        checkAC("avatar is not present on Page", homePage.isAvatarPresent(),true);
    }
}
