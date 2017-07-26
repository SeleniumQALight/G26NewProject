package LoginTests;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ParenPage;
import parentTest.ParentTest;

public class ValidLogOnTest extends ParentTest {

        @Test
    public void validLogOn(){
        loginInPage.openLoginPage();
        loginInPage.enterLoginToInput("Student");
        loginInPage.enterPassWordToInput("909090");
        loginInPage.clickOnSubmitButton();
        checkAC("Avatar is not present on Page", homePage.isAvatarPresent(),true);
    }
}
