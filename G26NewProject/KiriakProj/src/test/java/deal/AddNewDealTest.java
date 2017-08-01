package deal;

import org.junit.Test;
import parrentTest.ParrentTest;

public class AddNewDealTest extends ParrentTest {
    @Test
    public void addNewDeal(){
        loginPage.loginUser("Student","909090");
        homePage.clickOnMenuDeal();
        dealPage.checkTitle("Учет запчастей");
        dealPage.checkTitleH1PresentOnPageWithText("Сделки Список");
        dealPage.clickOnButtonPlus();
        addNewDealPage.checkTitleH1PresentOnPageWithText("Словарь");
        addNewDealPage.selectYearInDDByValue("2012");
        addNewDealPage.selectMonthInDDByValue("2");
        addNewDealPage.selectDayInDDByValue("2");
        addNewDealPage.selectHourInDDByValue("1");
        addNewDealPage.selectMinuteInDDByValue("10");
        addNewDealPage.selectTypeInDDByValue("48");
        addNewDealPage.selectCustomerInDDByValue("39");
        addNewDealPage.selectProviderInDDByValue("43");
        addNewDealPage.clickButtonCreate();
        dealPage.checkTitleH1PresentOnPageWithText("Сделки Список");
        checkAC("Can not find deal in list",dealPage.isDealInList("PRODAZHA"),true);
    }
}
