package spare;

import org.junit.Test;
import parrentTest.ParrentTest;

public class AddNewSpare extends ParrentTest {
    @Test
    public void addNewSpare(){
        loginPage.loginUser("Student","909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1PresentOnPageWithText("Запчасти Список");
    }
}
