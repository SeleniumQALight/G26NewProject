package spare;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * будет добавлять новые запчасти
 *
 */

public class addNewSpare extends ParentTest {

    @Test
    public void addNewSpare (){ //обзываем так же как и класс тк будет делать то же самое
        logInPage.loginUser("Student","909090"); //создаем метод котороый будет одной командой логинится на сайт
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей"); //тут именно тайтл страницы
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список"); //заходим на страницу и проверяем как написано в Н1!
        sparePage.clickOnButtonPlus();
        addNewSparePage.checkTitleH1PresentOnPageWithText("Словарь");
        addNewSparePage.enterSpareName("Spare1");
        addNewSparePage.selectElementFromDDSpare("Датчики jhlj");
        addNewSparePage.clickButtonCreate();
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        checkAC("Can not find spare in list",sparePage.isSpareInList("Spare1"), true);//создаем новый метод isSpareInList
    }

}