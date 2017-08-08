package loginTests;

import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by andrey.aleksandrov on 17.07.2017.
 */
public class InvalidLogOnWithoutPageObject extends ParentTest {

    public InvalidLogOnWithoutPageObject() {

    }

    @Test
    @Ignore
    public void invalidLogOn() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput( "student" );
        logInPage.enterPasswordToInput( "WrongPassword" );
        logInPage.clickOnSubmitButton();
        checkAC( "Text 'Учет запчастей' not found",
                logInPage.isElementWithTextPresent( "Учет запчастей" ), true );

    }

}

