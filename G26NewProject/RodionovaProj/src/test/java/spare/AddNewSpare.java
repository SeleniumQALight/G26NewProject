package spare;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Yuliya_Rodionova on 7/26/2017.
 */
public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
        loginPage.loginUser("Student","909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSparesSubMenu();
        sparePage.checkTitle("Учет запчастей");
        sparePage.chackTitleh1PresentOnPageWithText("Запчасти Список");
    }
}
