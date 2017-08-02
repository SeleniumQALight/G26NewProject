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
        sparePage.checkTitleh1PresentOnPageWithText("Запчасти Список");
        sparePage.clickOnButtonPlus();
        addNewSpare.checkTitleh1PresentOnPageWithText("Словарь");
        addNewSpare.enterSpareName("Spare1");
        addNewSpare.selectElementFromDDSpareType("Датчики івіфв");
        addNewSpare.clickOnButtonCreate();
        sparePage.checkTitleh1PresentOnPageWithText("Запчасти Список");
        checkAC("Can not find spare in list",sparePage.IsSpareInList("Spare1"), true);
    }
}
