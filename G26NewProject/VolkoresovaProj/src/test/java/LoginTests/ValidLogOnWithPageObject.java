package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by tatyanavolkorezova on 23.07.17.
 */
public class ValidLogOnWithPageObject extends ParentTest {
    public ValidLogOnWithPageObject() {
    }

    @Test
    public void validLogOn(){

        logInPage.openLogInPage();
        logInPage.enterLogInToInput("Student");
        logInPage.enterPassWordToInput("909090");
        logInPage.clickOnSubmitButton();
        checkAC("Text 'Главная' was not found", logInPage.isElementWithTextPresent("Главная"),true);



    }

}
