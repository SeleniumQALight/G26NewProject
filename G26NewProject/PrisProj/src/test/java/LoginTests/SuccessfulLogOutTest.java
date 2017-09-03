package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Dmitriy on 03.09.2017.
 */
public class SuccessfulLogOutTest extends ParentTest {

    public SuccessfulLogOutTest(String browser) {
        super(browser);
    }

    @Test
    public void successfulLogOut() {
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswordToInput("909090");
        loginPage.clickOnSubmitButton();
        homePage.clickOnRightAvatar();
        homePage.clickOnExitButton();
        checkAC("Logout was not successful", loginPage.checkTextInLoginForm("Авторизация"), true);
    }
}

