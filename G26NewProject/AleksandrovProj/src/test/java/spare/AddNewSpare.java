package spare;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by QA Teahcer on 26.07.2017.
 */
public class AddNewSpare extends ParentTest{
    @Test
    public void addNewSpare(){
        logInPage.loginUser("Student","909090");
        homePage.clickOnMenuDictionary();
        homePage.ClickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
//        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
//        sparePage.clickOnPlusButton();
//        addNewSparePage.checkTitleH1PresentOnPageWithText("Словарь");
//        addNewSparePage.enterSpareName("Spare1");
//        addNewSparePage.selectElementFromDDSpareType("Датчики івіфв");
//        addNewSparePage.clickButtonCreat();
//        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
//        checkAcceptanceCriteria("Can not find spare in list ",
//                sparePage.isSpareInList("Spare1")
//                ,true);
    }
}
