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
import pages.AddNewSparePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SparePage;
import spare.AddNewSpare;


import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;



public class ParentTest
{
    public WebDriver webDriver;
    public LoginPage logInPage;
    public HomePage homePage;
    public SparePage sparePage;
    public AddNewSparePage addNewSparePage;
    private Logger logger = Logger.getLogger(getClass());
    private Utils utils = new Utils();
    private String pathToScreenshot;

    private boolean isTestPass = false;

    public ParentTest()
    {

    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp()
    {
        File file = new File ("");
        pathToScreenshot = file.getAbsolutePath() + "\\target\\screenshots"
                + this.getClass().getPackage().getName() + "\\"
                + this.getClass().getSimpleName()
                + "\\" + this.testName.getMethodName() + ".jpg";
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",fileFF.getAbsolutePath());
        webDriver=new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logInPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        addNewSparePage = new AddNewSparePage(webDriver);
    }

    @After
    public void tearDown()
    {
        if (!(webDriver == null))
        {
            if (!isTestPass)
            {
                utils.screenShot(pathToScreenshot, webDriver);
            }
            webDriver.quit();
        }
    }

    public void checkAC (String message, boolean actualResult, boolean expectedResult)
    {
        Assert.assertThat(message, actualResult, is(expectedResult));
        setTestPass();
    }

    private void setTestPass()
    {
        isTestPass = true;
    }
}
