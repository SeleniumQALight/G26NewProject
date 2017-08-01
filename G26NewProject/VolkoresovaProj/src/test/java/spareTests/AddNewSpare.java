package spareTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by tatyanavolkorezova on 26.07.17.
 */
public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
        logInPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        sparePage.clickOnButtonPlus();
        addNewSparePage.checkTitleH1PresentOnPageWithText("Словарь");
        addNewSparePage.enterSpareName("Spare1");
        addNewSparePage.selectElementFromDDTypeOfSpare("Датчики івіфв");
        addNewSparePage.clickButtonCreate();
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        checkAC("Cannot find spare in list", sparePage.isSpareInList("Spare1"), true );
    }

    @Test
    public void addNewSpareWithValueFromDD(){
        logInPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        sparePage.clickOnButtonPlus();
        addNewSparePage.checkTitleH1PresentOnPageWithText("Словарь");
        addNewSparePage.enterSpareName("SpareVolkorezova with value from DD");
        addNewSparePage.selectElementFromDDTypeOfSpareByValue("16");
        addNewSparePage.clickButtonCreate();
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        checkAC("Cannot find spare in list", sparePage.isSpareInList("SpareVolkorezova with value from DD"),true);

    }

    @Test
    public void addNewSpareWithEmptyFields(){
        logInPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        sparePage.clickOnButtonPlus();
        addNewSparePage.clickButtonCreate();
        //check that user is still on the same page, cause name is required field
        checkAC("User should fill all fields", sparePage.checkTitleH1PresentOnPageWithTextBooleanRes("Словарь"),true);
    }


    @Test
    public void addNewSpareWithNotSelectedValueFromDD(){

        logInPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        sparePage.clickOnButtonPlus();
        addNewSparePage.selectElementFromDDTypeOfSpareByValue("16");
        addNewSparePage.clickButtonCreate();
        checkAC("User should fill all fields", sparePage.checkTitleH1PresentOnPageWithTextBooleanRes("Запчасти Список"),true);
    }

}
