package spare;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Dmitriy on 26.07.2017.
 */
public class AddNewSpare extends ParentTest{

    @Test
    public void addNewSpare () { //Метод работает с страницой Словари Запчасти
        loginPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1PresentOnPagewithText("Запчасти Список");
        sparePage.clickOnButtonPlus();
        addNewSparePage.checkTitleH1PresentOnPagewithText("Словарь");
        addNewSparePage.enterSpareName("Spare1");
        addNewSparePage.selectElementDropDownSpareType("Датчики івіфв");
        addNewSparePage.clickButtonCreate();
        sparePage.checkTitleH1PresentOnPagewithText("Запчасти Список");
        checkAC("Can not find spare in list", sparePage.isSpareInList("Spare1"),
                true);
    }
}
