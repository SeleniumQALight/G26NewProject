package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Оля on 24.07.2017.
 */
public class ValidLogOnTest extends ParentTest {

    @Test
    public void validLogOn(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswordToInput("909090");
        loginPage.pressButtonSubmit();
        //loginPage.checkTitle("Account of spare:Авторизация");
        checkAC("Avatar is not present on Page",homePage.isAvatarPresent(), true);
    }
}
