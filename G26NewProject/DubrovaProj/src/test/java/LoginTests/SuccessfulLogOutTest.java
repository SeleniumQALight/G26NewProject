package LoginTests;


import org.junit.Test;
import parentTest.ParentTest;

public class SuccessfulLogOutTest extends ParentTest{

    @Test
    public void successfulLogOut(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswordToInput("909090");
        loginPage.clickOnSubmitButton();
        homePage.clickOnRightAvatar();
        homePage.clickOnExitButton();
        checkAC("Logout was not successful", loginPage.checkTextInLoginForm("Авторизация"), true);

    }

}
