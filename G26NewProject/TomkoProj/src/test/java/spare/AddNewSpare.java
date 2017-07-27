package spare;


import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
     loginInPage.loginUser("Student","909090"); //loginUser- метод  залогинься и даем параметры
     homePage.clickOnMenuDictionary();
     homePage.clickOnSubMenu();
     sparePage.ckeckTitle("Учет запчастей");
     sparePage.checkTitleH1PresentOnPage("Запчасти Список");
     sparePage.clickOnButtonPlus();
     addNewSparePage.checkTitleH1PresentOnPage("Словарь");
     addNewSparePage.enterSpareName("Spare1");
     addNewSparePage.selectElementFromDDSpareeType("Датчики івіфв");
     addNewSparePage.clickButtonCreate();


     sparePage.checkTitleH1PresentOnPage("Запчасти Список");
     checkAC("Can not find spare in list",sparePage.isSpareInList("Spare1"),true);
    }

}
