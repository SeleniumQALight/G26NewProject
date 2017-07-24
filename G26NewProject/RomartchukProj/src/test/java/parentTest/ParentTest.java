package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Oleg on 17.07.2017.
 */
public class ParentTest {
    public WebDriver webDriver;
    public LoginPage loginPage;

    public ParentTest() {

    }

    @Before
    public void setUp() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();

    }
    public void checkAC(String messages,boolean actualResult, boolean expectedResult){
        Assert.assertThat(messages,actualResult,is(expectedResult));

    }

}
