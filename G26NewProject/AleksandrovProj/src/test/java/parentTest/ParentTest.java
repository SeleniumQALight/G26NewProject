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
 * Created by andrey.aleksandrov on 17.07.2017.
 */
public class ParentTest {
    public WebDriver webDriver;
    public LoginPage logInPage;

    public ParentTest() {

    }

    @Before
    public void setUp() {
        File driverPath = new File( ".././drivers/chromedriver.exe" );
        System.setProperty( "webdriver.chrome.driver", driverPath.getAbsolutePath() );
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
        logInPage = new LoginPage( webDriver );
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    public void checkAcceptanceCriteria(String message, boolean actualResult, boolean expectedResult) {
        Assert.assertThat( message, actualResult, is( expectedResult ) );
    }
}
