package Spare;

import org.junit.Test;
import parrentTest.ParrentTest;

//extends ParrentTest - прописуем что наследовался
public class AddNewSpare extends ParrentTest {
    // создаем @Test
    @Test
    public void addNewSpare(){
        // пишем залогиниться на сайте, одна команда ( метод )
        //loginUser - создать метод в папке ЛогинПейдж который будет универсален для логирования
        loginPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        sparePage.clickOnTheButtonPlus();
        addNewSparePage.checkTitleH1PresentOnPageWithText("Словарь");
        addNewSparePage.enterSpareName("Spare1");
        addNewSparePage.selectElementFromDropDownTypeOfSpare("Датчики івіфв");
        addNewSparePage.clickOnTheButtonCreate();
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        checkAC("Cannot find the spare in list", sparePage.isSpareInList("Spare1"),true);
    }
}
