package providersTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by tatyanavolkorezova on 29.07.17.
 */
public class AddNewProviders extends ParentTest{


    @Test
    public void addNewProvider(){
        logInPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkTitle("Учет запчастей");
        providersPage.checkTitleH1PresentOnPageWithText("Стороны сделок Список");
        providersPage.clickOnButtonAdd();
        addNewProvidersPage.checkTitleH1PresentOnPageWithText("Словарь");
        addNewProvidersPage.enterProviderName("Provider1");
        addNewProvidersPage.enterProviderAddres("Lenina");
        addNewProvidersPage.enterProviderPhone("444444444");
        addNewProvidersPage.checkCheckBoxPrivatePerson();
        addNewProvidersPage.checkCheckBoxIsOurFirm();
        addNewProvidersPage.clickButtonCreate();
        providersPage.checkTitleH1PresentOnPageWithText("Стороны сделок Список");
        checkAC("Cannot find provider in list", providersPage.isProviderInList("Provider1"), true );
    }
}
