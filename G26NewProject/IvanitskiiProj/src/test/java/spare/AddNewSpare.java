package spare;


import org.junit.Test;
import pages.LogInPage;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest{
    @Test
    public void addNewSpare(){
        logInPage.loginUser("Student", "909090");
        homePage.clickOnMenuDicionary();
        homePage.clickOnSubMenuSpares();
        sparePage.chckTitle("Учет запчастей");
        sparePage.checkTitleH1presentHomePageWithtext("Запчасти Список");
        sparePage.clickOnButtonPlus();
        addNewSparePage.checkTitleH1presentHomePageWithtext("Словарь");
        addNewSparePage.enterSpareName("Spare1");
        addNewSparePage.selectElemetFromDDSpareText("Датчики івіфв");
        addNewSparePage.clickButtonCreate();
        sparePage.checkTitleH1presentHomePageWithtext("Запчасти Список");
        checkAC("Can not finde spare in list ", sparePage.isSpareInList("Spare1"), true);
    }

}
