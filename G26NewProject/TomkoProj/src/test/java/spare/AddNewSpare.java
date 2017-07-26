package spare;


import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare(){
     loginInPage.loginUser("Student","909090"); //loginUser- метод  залогинься и даем параметры
     homePage.clickOnMenuDictionary();
     sparePage.ckeckTitle("Учет запчастей");
     sparePage.checkTitleH1PresentOnPage("Запчасти Список");
    }

}
