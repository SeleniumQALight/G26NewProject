package loginTests;

import org.junit.Test;
import pages.HomePage;
import parentTest.ParentTest;

public class ValidLoginTest extends ParentTest {

    @Test
    public void validLogin() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput( "student" );
        logInPage.enterPasswordToInput( "909090" );
        logInPage.clickOnSubmitButton();

        checkAcceptanceCriteria( "Avatar is not present on page.", homePage.isAvatarPresent(), true );
    }

}
