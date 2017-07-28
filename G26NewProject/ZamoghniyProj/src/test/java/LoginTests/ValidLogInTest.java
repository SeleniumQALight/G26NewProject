package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Asus on 24.07.2017.
 */
public class ValidLogInTest extends ParentTest {
    @Test
    public void validLogOn(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswordToInput("909090");
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not Present on Page",homePage.isAvatarPresent(),true);
    }

}
