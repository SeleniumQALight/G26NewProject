package loginTest;


import org.junit.Test;
import parentTest.ParentTest;

public class ValidLogInTest extends ParentTest
{
    @Test
    public void validLogIn ()
    {
        logInPage.openLoginPage();
        logInPage.enterLogInToInput("Student");
        logInPage.enterPasswordToInput("909090");
        logInPage.clickOnSubmitButton();
        checkAC("Avatar is not present on Page", homePage.isAvatarPresent(), true);
    }
}
