package LoginTests;


import org.junit.Test;
import parentTest.ParentTest;


public class TitleCheck extends ParentTest {

    public TitleCheck(){
    }

    @Test
    public void titleCheck(){
        loginPage.openLoginPage();
        loginPage.checkTitle("Account of spare:Авторизация");

    }
}
