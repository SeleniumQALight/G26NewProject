package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by User on 24.07.2017.
 */
public class ValidLogOnTest extends ParentTest {
    @Test
    public void validLogOn(){
        logInPage.openLoginPage();
        logInPage.enterLoginToInput("Student");
        logInPage.enterPasswordIntoElement("909090");
        logInPage.clickOnSubmitButton();
        checkAcceptanceCriteria("Avatar is not present on Page",homePage.isAvatarPresent(),true);


    }

}
