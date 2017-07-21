package loginTests;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Created by andrey.aleksandrov on 17.07.2017.
 */
public class InvalidLogOnWithoutPageObject extends ParentTest {

    public InvalidLogOnWithoutPageObject() {

    }

    @Test
    public void invalidLogOn() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput( "student" );
        logInPage.enterPasswordToInput( "WrongPassword" );
        logInPage.clickButton();
        checkAcceptanceCriteria( "Text 'Учет запчастей' not found",
                logInPage.isElementWithTextPresent("Учет запчастей"),  true );

    }

}

