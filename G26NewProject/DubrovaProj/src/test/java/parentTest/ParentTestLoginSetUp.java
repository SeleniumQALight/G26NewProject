package parentTest;

import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import parentTest.ParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kleine-Hexe on 23.07.2017.
 */
public class ParentTestLoginSetUp extends ParentTest {
    public MainPage mainPage;
    public ParentTestLoginSetUp() {
    }
    @Before
    public void setUp(){
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswordToInput("909090");
        loginPage.clickOnSubmitButton();
        mainPage = new MainPage(webDriver);

    }

}
