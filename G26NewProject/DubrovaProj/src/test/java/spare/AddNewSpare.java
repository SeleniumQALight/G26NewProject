package spare;


import org.junit.Test;
import parentTest.ParentTest;


public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
    loginPage.loginUser("Student","909090");
    homePage.clickOnMenuDictionary();
    homePage.clickOnSubMenu();
    sparePage.checkTitle("Учет запчастей");
    sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
    }
}
