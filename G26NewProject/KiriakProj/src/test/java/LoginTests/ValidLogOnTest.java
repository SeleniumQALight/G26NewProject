package LoginTests;

import org.junit.Test;
import parrentTest.ParrentTest;

public class ValidLogOnTest extends ParrentTest {
    @Test
    public void validLogOn(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswordToInput("909090");
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not present on Page", homePage.isAvatarPresent(), true);
    }
}
