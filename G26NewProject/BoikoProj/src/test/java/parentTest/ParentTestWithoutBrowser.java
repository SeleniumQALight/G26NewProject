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
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Оля on 08.08.2017.
 */
public class ParentTestWithoutBrowser {
    public WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    private Utils utils = new Utils();
    private String pathToScreenshot;
    private boolean isTestPass = false; // Results of the test is saved to this variable

    //initialize all pages
    public LoginPage loginPage;
    public HomePage homePage;
    public SparePage sparePage;
    public AddNewSparePage addNewSparePage;
    public ProvidersPage providersPage;
    public EditProviderPage editProviderPage;
    public ProfilePage profilePage;

    public ParentTestWithoutBrowser() {

    }

    @Rule
    public TestName testName = new TestName(); //Object which receive information about current name of run test


    @Before
    public void setUp() {
        File file = new File("");
        pathToScreenshot = file.getAbsolutePath() + "\\target\\screenshots\\" + this.getClass().getPackage().getName() +"\\" + this.getClass().getSimpleName() + "\\" + this.testName.getMethodName()+".jpg";
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // create objects of the pages
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        addNewSparePage = new AddNewSparePage(webDriver);
        providersPage = new ProvidersPage(webDriver);
        editProviderPage = new EditProviderPage(webDriver);
        profilePage = new ProfilePage(webDriver);

    }

    @After
    public void tearDown() {
        if (!(webDriver==null)) {  // Close web driver only if web driver exists
            if (!isTestPass) {
                utils.screenShot(pathToScreenshot, webDriver); //Take screenshot if test is failed
            }
            webDriver.quit();
        }
    }

    public void checkAC(String message, boolean actualResult, boolean expectedResult){

        Assert.assertThat(message,actualResult, is(expectedResult));
        setTestPass(); //Method which set test to pass
    }

    private void setTestPass() {
        isTestPass = true;
    }

}


