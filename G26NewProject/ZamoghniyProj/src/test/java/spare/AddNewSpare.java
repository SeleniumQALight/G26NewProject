package spare;


import LoginTests.ValidLogInTest;
import libs.Utils;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest{

    Utils u = new Utils();
    ValidLogInTest valid = new ValidLogInTest();
    @Test
    //@Ignore if we want skip one test - not realised functional or this functional under maintance(regresion testing)
    public void addNewSpare (){
        loginPage.loginUser("Student","909090"); //логинимся и переходим на майн пейдж

        homePage.clickOnDictionaryMenu(); //кликаем на пункт меню Словари
        homePage.clickOnSparesSubMenu(); //Выбираем там запчасти
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1WithText("Запчасти Список");
        sparePage.clickOnButtonPlus();
        sparePage.checkTitleH1WithText("Словарь");
        addNewSpare.enterSpareName("Spare1");
        addNewSpare.selectElementFromDDTypeOfSpare("Датчики івіфв");
        addNewSpare.clickOnCreateButton();
        sparePage.checkTitleH1WithText("Запчасти Список");
        checkAC("can not find spare in list ",sparePage.isSpareInList("Spare1"), true);

    }
}
