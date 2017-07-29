package loginTests;

import parentTest.ParentTest;

public class ValidLoginTest extends ParentTest {

    public void validLogOn () {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput("Student");
        logInPage.enterPasswordToInput("909090");
        logInPage.clickOnSubmitButton();
        checkAC("Avatar is not present on page",
                            homePage.isAvatarPresent(),
                            true);


    }

}
