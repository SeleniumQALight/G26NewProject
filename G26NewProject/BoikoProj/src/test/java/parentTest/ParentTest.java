package parentTest;

import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;
import spare.AddNewSpare;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Оля on 17.07.2017.
 */
@RunWith(value = Parameterized.class)

public class ParentTest {
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

    private String browser;

    public ParentTest(String browser) {
        this.browser = browser;
    }

    public ParentTest() {
    }

    @Parameterized.Parameters
     public static Collection testData() throws IOException {
        return Arrays.asList(new Object[][]{
                // {"fireFox"}
                // ,
                //{"chrome"},
                {"iedriver"}
                //,
                //{ "opera" }
                //,
                //{"phantomJs"}
                });
        }

    @Rule
    public TestName testName = new TestName(); //Object which receive information about current name of run test


    @Before
    public void setUp() {
        File file = new File("");

        if ("fireFox".equals(browser)) {
                        logger.info("FireFox will be started ");
                        File fileFF = new File(".././drivers/geckodriver.exe");
                        System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
                        FirefoxProfile profile = new FirefoxProfile();
                        profile.setPreference("browser.startup.page", 0); // Empty start page
                        profile.setPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
                        webDriver = new FirefoxDriver(profile);
                        logger.info(" FireFox is started");
                    } else if ("chrome".equals(browser)) {
                        logger.info("Chrome will be started ");
                        File fileFF = new File(".././drivers/chromedriver.exe");
                        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
                        webDriver = new ChromeDriver();
                        logger.info(" Chrome is started");
                    } else if ("iedriver".equals(browser)) {
                        logger.info("IE will be started ");
                        File file1 = new File(".././drivers/IEDriverServer.exe");
                        System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
                        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                        capabilities.setCapability("ignoreZoomSetting", true);
                        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                        webDriver = new InternetExplorerDriver();
                        logger.info(" IE is started");
                    } else if ("opera".equals(browser)) {
                        logger.info("Opera will be started");
                        File fileOpera = new File(".././drivers/operadriver.exe");
                        System.setProperty("webdriver.chrome.driver", fileOpera.getAbsolutePath());
                        webDriver = new ChromeDriver();
                        logger.info(" Opera is started");
                    } else if ("phantomJs".equals(browser)){
                        logger.info("PHANTOMJS will be started");
                        DesiredCapabilities caps = new DesiredCapabilities();
                        caps.setJavascriptEnabled(true);
                        caps.setCapability("takesScreenshot", true);
                        caps.setCapability(
                                        PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                                        ".././drivers/phantomjs-2.1.1-windows/bin/phantomjs.exe"
                                        );
                        webDriver = new PhantomJSDriver(caps);
                        logger.info(" PHANTOMJS is started");
                    }

        pathToScreenshot = file.getAbsolutePath() + "\\target\\screenshots\\" + this.getClass().getPackage().getName()
                +"\\" + this.getClass().getSimpleName() + "\\"
                + this.testName.getMethodName() + "-" + browser + ".jpg";
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

        if (!(actualResult == expectedResult)) {
            utils.screenShot(pathToScreenshot, webDriver);
            logger.error("AC failed: " + message);
            }
        Assert.assertThat(message + "Browser - " + browser + " ScreenShot " + pathToScreenshot,actualResult,is(expectedResult));

        setTestPass(); //Method which set test to pass
    }

    private void setTestPass() {
        isTestPass = true;
    }

}
