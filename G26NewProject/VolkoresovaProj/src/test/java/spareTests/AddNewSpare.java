package spareTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by tatyanavolkorezova on 26.07.17.
 */
public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
        logInPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        sparePage.clickOnButtonPlus();
        addNewSparePage.checkTitleH1PresentOnPageWithText("Словарь");
        addNewSparePage.enterSpareName("Spare1");
        addNewSparePage.selectElementFromDDTypeOfSpare("Датчики івіфв");
        addNewSparePage.clickButtonCreate();
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        checkAC("Cannot find spare in list", sparePage.isSpareInList("Spare1"), true );




    }
}
