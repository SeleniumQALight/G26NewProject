package providers;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Оля on 31.07.2017.
 */
public class EditProvider extends ParentTest {

    @Test
    public void editProvider(){
        loginPage.loginUser("Student","909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkTitle("Учет запчастей");
        providersPage.checkTitleH1PresentOnPageWithText("Стороны сделок Список");
        providersPage.clickOnProvider("ООО \"СТО Попрошенко\"");
        editProviderPage.checkTitleH1PresentOnPageWithText("Словарь");
        editProviderPage.makeProviderAsPrivatePerson();
        editProviderPage.clickOnButtonSave();
        providersPage.checkTitleH1PresentOnPageWithText("Стороны сделок Список");
        checkAC("Provider is not Private Person", providersPage.isProviderPrivatePerson("ООО \"СТО Попрошенко\""),true);



    }

}
