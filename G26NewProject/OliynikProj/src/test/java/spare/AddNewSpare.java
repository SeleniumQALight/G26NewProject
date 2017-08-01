package spare;

import org.junit.Test;
import pages.HomePage;
import parentTest.ParentTest;

/**
 * Created by Oliynik on 26.07.2017.
 */
public class AddNewSpare extends ParentTest{
    @Test

    public void addNewSpare(){
        logInPage.loginUser("Student","909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1OnPage("Запчасти Список");
sparePage.clickOnButtonPlus();
addNewSparePage.checkTitleH1OnPage("Словарь");
addNewSparePage.enterSpareName("Spare1");
addNewSparePage.selectElementFromDDSpareType("Датчики івіфв");
addNewSparePage.clickButtonCreate();
sparePage.checkTitleH1OnPage("Запчасти Список");
checkAcceptanceCriteria("Can not find spare in list",sparePage.isSpareInList("Spare1"), true );
    }
}