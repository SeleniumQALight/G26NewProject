package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class ValidLoginTest extends ParentTest {

    @Test
    public void validLogin() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput( "student" );
        logInPage.enterPasswordToInput( "909090" );
        logInPage.clickOnSubmitButton();

        checkAC( "Avatar is not present on page.", homePage.isAvatarPresent(), true );
    }

}
