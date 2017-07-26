package LoginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class ValidLogOnTest extends ParentTest {
    @Test
    public void validLogOn(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswToInput("909090");
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not present on Page", homePage.isAvatarPresent(), true);
    }
}
