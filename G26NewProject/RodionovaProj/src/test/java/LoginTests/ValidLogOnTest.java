package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Yuliya_Rodionova on 7/24/2017.
 */
public class ValidLogOnTest extends ParentTest {
    @Test
    public  void validLogOn(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswordToInput("909090");
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not present on the Page!",homePage.isAvatarPresnt(), true);

    }

}
