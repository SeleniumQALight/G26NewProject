package spare;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by Dmitriy on 26.07.2017.
 */
public class AddNewSpare extends ParentTest{

    //Конструктор - используй вебдрайвер обьект который обьявлен в родителе.
    //public AddNewSpare() {}

    //Создаем новый конструктор для параметризированного теста разных браузеров
    public AddNewSpare(String browser) {
        super(browser);
    }

    @Test
    //@Ignore
    public void addNewSpare () { //Метод работает с страницой Словари Запчасти
        loginPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1PresentOnPagewithText("Запчасти Список");
        sparePage.clickOnButtonPlus();
        addNewSparePage.checkTitleH1PresentOnPagewithText("Словарь");
        addNewSparePage.enterSpareName("Spare1");
        //addNewSparePage.selectElementDropDownSpareType("Датчики івіфв");
        addNewSparePage.select1ElementDropDownSpareType("4");
        addNewSparePage.clickButtonCreate();
        sparePage.checkTitleH1PresentOnPagewithText("Запчасти Список");
        checkAC("Can not find spare in list", sparePage.isSpareInList("Spare1"),
                true);
    }
}
