package LoginTests;

import org.junit.Test;
import pages.ParentPage;
import parentTest.ParentTest;

/**
 * Created by Оля on 01.08.2017.
 */
public class ChangeUserName extends ParentTest{

    @Test
    public void changeUserName() {
        loginPage.loginUser("Student", "909090");
        homePage.clickOnRightLoginName();
        homePage.clickOnProfileButton();
        homePage.checkTitle("Учет запчастей");
        homePage.checkTitleH1PresentOnPageWithText("Профиль");
        profilePage.enterUserName("Студент новый");
        profilePage.clickOnSaveButton();
        profilePage.checkTitleH3WithUserName("Студент новый");
        homePage.isRightUserNameTextCorrect("Студент новый");
        homePage.isLeftUserNameTextCorrect("Студент новый");
        //checkAC("Right user name is not correct", homePage.isRightUserNameTextCorrect("Студент новый"), true);
        //checkAC("Left user name is not correct", homePage.isLeftUserNameTextCorrect("Студент новый"), true);
    }
}
