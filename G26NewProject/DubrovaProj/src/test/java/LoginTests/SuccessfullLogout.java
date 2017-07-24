package LoginTests;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTestLoginSetUp;

/**
 * Created by Kleine-Hexe on 23.07.2017.
 */
public class SuccessfullLogout extends ParentTestLoginSetUp{

    @Test
    public void successfullLogout(){
    mainPage.clickOnAvatar();
//    Assert.assertTrue("Profile Pop-up not displayed", mainPage.isProfilePopUpPresent());
    mainPage.clickOnLogoutButton();
    checkAC("Text 'Учет запчастей' not found",
                loginPage.isElementWithTextPresent("Учет запчастей"), true);

    }

}
