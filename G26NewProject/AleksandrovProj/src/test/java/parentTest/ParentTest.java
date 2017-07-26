package parentTest;

import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

import javax.rmi.CORBA.Util;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by andrey.aleksandrov on 17.07.2017.
 */
public class ParentTest {
    private Logger logger = Logger.getLogger( getClass() );
    private Utils utils = new Utils();
    private String pathToScreenShot;
    public WebDriver webDriver;
    public LoginPage logInPage;
    public HomePage homePage;

    public ParentTest() {
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        File file = new File( "" );
        pathToScreenShot = file.getAbsolutePath() + "\\target\\screenshots\\"
                + this.getClass().getPackage().getName() + "\\"
                + this.getClass().getSimpleName() + "\\"
                + this.testName.getMethodName() + ".jpg";
        File driverPath = new File( ".././drivers/chromedriver.exe" );
        System.setProperty( "webdriver.chrome.driver", driverPath.getAbsolutePath() );
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
        logInPage = new LoginPage( webDriver );
        homePage = new HomePage( webDriver );
    }

    @After
    public void tearDown() {
        if (webDriver != null){
            utils.screenShot( pathToScreenShot, webDriver );
            webDriver.quit();
        }

    }

    public void checkAcceptanceCriteria(String message, boolean actualResult, boolean expectedResult) {
        if (actualResult != expectedResult) {

        }
        Assert.assertThat( message, actualResult, is( expectedResult ) );
    }
}
