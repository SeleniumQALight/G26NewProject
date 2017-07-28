package spare;


import org.junit.Test;
import parentTest.ParentTest;


public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
    loginPage.loginUser("Student","909090");
    homePage.clickOnMenuDictionary();
    homePage.clickOnSubMenuSpares();
    sparePage.checkTitle("Учет запчастей");
    sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
    sparePage.clickOnButtonPlus();
    addNewSparePage.checkTitleH1PresentOnPageWithText("Словарь");
    addNewSparePage.enterSpareName("Spare1");
    addNewSparePage.selectElementFromDDSpareType("Датчики івіфв");
    addNewSparePage.clickButtonCreate();
    sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
    checkAC("Cannot find the spare in list", sparePage.isSpareInList("Spare1"),true);
    }
}
