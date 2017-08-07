package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;


public class ValigLogOnTest extends ParentTest {
    public ValigLogOnTest(String browser) {
        super(browser);
    }
    
    @Test
    public void validLogOn(){
        logInPage.openLoginPage();
        logInPage.enterLoginToInput("Student");
        logInPage.enterPassWordToInput("909090");
        logInPage.clickOnSubmitButton();
        checkAC("Avatar is not present on Page",
                homePage.isAvatarPresent(),
                true);
    }
}
