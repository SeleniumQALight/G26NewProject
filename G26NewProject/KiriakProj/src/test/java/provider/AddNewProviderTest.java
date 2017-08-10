package provider;

import org.junit.Test;
import parrentTest.ParrentTest;


public class AddNewProviderTest extends ParrentTest{
    public AddNewProviderTest(String browser) {
        super(browser);
    }
    @Test
    public void addNewProvider(){
        loginPage.loginUser("Student","909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkTitle("Учет запчастей");
        providersPage.checkTitleH1PresentOnPageWithText("Стороны сделок Список");
        providersPage.clickOnButtonPlus();
        addNewProviderPage.checkTitleH1PresentOnPageWithText("Словарь");
        addNewProviderPage.enterProCustName("Provider1");
        addNewProviderPage.enterProCustAddress("Ukraine");
        addNewProviderPage.enterProCustPhone("044-456-54-86");
        addNewProviderPage.selectCheckBoxPrivatePerson();
        addNewProviderPage.selectCheckBoxIsOurFirm();
        addNewProviderPage.clickButtonCreate();
        providersPage.checkTitleH1PresentOnPageWithText("Стороны сделок Список");
        checkAC("Can not find provider in list", providersPage.isProviderInList("Provider1"),true);
    }
}
