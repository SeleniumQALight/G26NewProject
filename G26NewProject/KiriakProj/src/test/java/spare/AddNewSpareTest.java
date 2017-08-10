package spare;

import org.junit.Test;
import parrentTest.ParrentTest;

public class AddNewSpareTest extends ParrentTest {
    public AddNewSpareTest(String browser) {
        super(browser);
    }

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
        checkAC("Can not find spare in list",sparePage.isSpareInList("Spare1"),true);
    }
}
