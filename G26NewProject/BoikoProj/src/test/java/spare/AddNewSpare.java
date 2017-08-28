package spare;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Оля on 26.07.2017.
 */
public class AddNewSpare extends ParentTest{

    public AddNewSpare(String browser) {
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
        //addNewSparePage.selectElementFromDDSpareTypeByText("Датчики івіфв");
        addNewSparePage.selectElementFromDDSpareTypeByValue("4");
        addNewSparePage.clickButtonCreate();
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        checkAC("Can not find spare in list", sparePage.isSpareInList("Spare1"),true);
    }
}
