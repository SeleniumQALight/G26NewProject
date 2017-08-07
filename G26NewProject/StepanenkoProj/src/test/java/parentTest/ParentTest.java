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
import pages.HomePage;
import pages.LogInPage;
import pages.SparePage;

import java.io.File;
import java.util.concurrent.TimeUnit;


import static org.hamcrest.CoreMatchers.is;

public class ParentTest {
    public WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    private Utils utils = new Utils();
    private String pathToScreenShot;

    private boolean isTestPass = false;

    public LogInPage logInPage;
    public HomePage homePage;
    public SparePage sparePage;
    public AddNewSparePage addNewSparePage;

    public ParentTest() {

    }

    @Rule
    public TestName testName = new TestName();

    //если условия в before не выполнились , то дальше тест не идет
    //before выполняется ТОЛЬКО 1 раз перед тестом
    @Before
    public void setUp() {
    File file = new File("");
    pathToScreenShot = file.getAbsolutePath() + "\\target\\screenshots\\"
            + this.getClass().getPackage().getName() + "\\"
            + this.getClass().getSimpleName() + "\\"
            + this.testName.getMethodName() + ".jpg";

    File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

        /**
         * webDriver = new ChromeDriver(); - команда открыть браузер
         */
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logInPage = new LogInPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        addNewSparePage = new AddNewSparePage(webDriver);
    }

    //after выполняется ТОЛЬКО 1 раз после тестa
    @After
    public void tearDown() {
        if (!(webDriver==null)) {
            if (!isTestPass) {
                utils.screenShot(pathToScreenShot, webDriver);
            }
            webDriver.quit();
        }
    }

    public void checkAC(String message, boolean actualResult
            , boolean expectedResult){

        Assert.assertThat(message,actualResult,is(expectedResult));
        setTestPass();
    }

    private void setTestPass() {
        isTestPass = true;
    }
}


