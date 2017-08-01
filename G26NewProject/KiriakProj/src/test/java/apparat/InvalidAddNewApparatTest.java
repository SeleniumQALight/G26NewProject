package apparat;

import org.junit.Test;
import parrentTest.ParrentTest;


public class InvalidAddNewApparatTest extends ParrentTest{
    @Test
    public void invalidAddNewApparat(){
        loginPage.loginUser("Student","909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuApparat();
        apparatPage.checkTitle("Учет запчастей");
        apparatPage.checkTitleH1PresentOnPageWithText("Аппарат Список");
        apparatPage.clickOnButtonPlus();
        addNewApparatPage.checkTitleH1PresentOnPageWithText("Словарь");
        addNewApparatPage.enterApparatNumber("111");
        addNewApparatPage.clickButtonCreate();
        checkAC("Text 'Словарь' not found",apparatPage.isElementWithTestPresent("Словарь"),true);
    }
}
