package LoginTests;


import org.junit.Test;
import parentTest.ParentTest;

public class ValidLogOnTest extends ParentTest{
    @Test
    public void validlogOn() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput("Student");
        logInPage.enterpassWordToInput("909090");
        logInPage.clickOnSubmitButtton();
        checkAC("Avatart is not present on page", homePage.isAvatarPresent(), true);
    }
}