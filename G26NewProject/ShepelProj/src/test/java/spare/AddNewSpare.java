package spare;


import org.junit.Test;
        import parentTest.ParentTest;

public class AddNewSpare extends ParentTest { // класс по созданию новой запчасти
    @Test
    public void addNewSpare() {
        logInPage.logInUser("Student", "909090"); // для быстроты в LogInPage создаем метод по логину logInUser
        homePage.clickOnMenuDictionary(); // кликаем по менюшке "Словари"
        homePage.clickOnSubMenuSpares(); // кликаем по меню "Запчасти"
        sparePage.checkTitle("Учет запчастей"); // проверяем тайтл
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        sparePage.clickOnButtonPlus();
        addNewSparePage.checkTitleH1PresentOnPageWithText("Словарь");
        addNewSparePage.enterSpareName("Spare1");
        addNewSparePage.selectElementFromDDSpareType("Датчики івіфв");
        addNewSparePage.clickButtonCreat();
        addNewSparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
        checkAC("Can not find spare in list", sparePage.isSpareInList("Spare1"), true);

    }

}
