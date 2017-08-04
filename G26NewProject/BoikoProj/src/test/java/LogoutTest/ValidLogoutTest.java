package LogoutTest;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Оля on 01.08.2017.
 */
public class ValidLogoutTest extends ParentTest{

    @Test
    public void validLogoutTest() {
        loginPage.loginUser("Student", "909090");
        homePage.clickOnRightLoginName();
        homePage.clickOnLogoutButton();
        loginPage.checkTitle("Account of spare:Авторизация");
        checkAC("Login field is not empty", loginPage.isFieldLoginInitiallyEmpty(), true);
        checkAC("Password field is not empty", loginPage.isFieldPasswordInitiallyEmpty(), true);
    }
}
