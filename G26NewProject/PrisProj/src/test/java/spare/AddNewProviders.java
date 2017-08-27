package spare;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Dmitriy on 13.08.2017.
 */
public class AddNewProviders extends ParentTest {

    //Конструктор - используй вебдрайвер обьект который обьявлен в родителе.
    //public AddNewProviders() {}

    //Создаем новый конструктор для параметризированного теста разных браузеров
    public AddNewProviders(String browser) {
        super(browser);
    }

    @Test
    public void addNewProviders() { //Метод работает с страницой Стороны сделок Словарь
        loginPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkTitle("Учет запчастей");
        providersPage.checkTitleH1PresentOnPagewithText("Стороны сделок Список");
        providersPage.clickOnButtonPlus();
        addNewProvidersPage.checkTitleH1PresentOnPagewithText("Словарь");
        addNewProvidersPage.enterProvidersName("Spare1");
        addNewProvidersPage.enterProvidersNameAddress("Kirova 5");
        addNewProvidersPage.enterProvidersNamePhone("+380737427180");
        //addNewProvidersPage.clickCheckboxPrivatePerson();
        //addNewProvidersPage.clickCheckboxIsOurFirm();
        addNewProvidersPage.clickProvidersButtonCreate();
        providersPage.checkTitleH1PresentOnPagewithText("Стороны сделок Список");
        providersPage.clickOnProvider("Spare1");
        addNewProvidersPage.checkTitleH1PresentOnPagewithText("Словарь");
        addNewProvidersPage.makeProviderAsPrivatePerson();
        addNewProvidersPage.clickProvidersButtonSave();
        providersPage.checkTitleH1PresentOnPagewithText("Стороны сделок Список");
        checkAC("Provider is not Private Person", providersPage.isProviderPrivatePerson("Spare1"), true);
        //Обращаемся к методу который будет кликать на елемент по указанному имени
        providersPage.clickOnProvider("Spare1");
        providersPage.clickButtonDelete();

    }
}
