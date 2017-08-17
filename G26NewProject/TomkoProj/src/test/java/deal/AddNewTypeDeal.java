package deal;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ParenPage;
import parentTest.ParentTest;

public class AddNewTypeDeal extends ParentTest{

    @Test
    public void addNewTypeDeal(){
        loginInPage.loginUser("Student", "909090");
        homePage.clickOnMenuDeal();
        dealPage.ckeckTitle("Учет запчастей");
        dealPage.checkTitleH1PresentOnPage("Сделки Список");
        dealPage.clickOnTypeFirstRow();
        addNewDealPage.checkTitleH1PresentOnPage("Словарь");
        addNewDealPage.selectTypeInDDByValue("10");
        addNewDealPage.clickButtonSave();
        dealPage.checkTitleH1PresentOnPage("Сделки Список");

        checkAC("Can not find typeDeal in list",dealPage.isTypeInList("POKUPKA"),true);
    }
}
