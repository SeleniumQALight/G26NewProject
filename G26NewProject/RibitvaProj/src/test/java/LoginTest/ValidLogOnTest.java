package LoginTest;


import org.junit.Test;
import parentTest.ParentTest;

public class ValidLogOnTest extends ParentTest{
    @Test
    public void validLogOn(){
        loginPage.openloginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPassWordToInput("909090");
        loginPage.clickOnSubmitButton();
        checkAC("Avanar is not present on Page",
                homePage.isAvatarPresent(),
                true);
    }
}
