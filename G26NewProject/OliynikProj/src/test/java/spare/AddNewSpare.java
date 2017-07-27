package spare;

import org.junit.Test;
import pages.HomePage;
import parentTest.ParentTest;

/**
 * Created by User on 26.07.2017.
 */
public class AddNewSpare extends ParentTest{
    @Test

    public void addNewSpare(){
        logInPage.loginUser("Student","909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle("Учет запчастей");
        sparePage.checkTitleH1OnPage("Запчасти Список");     }
}