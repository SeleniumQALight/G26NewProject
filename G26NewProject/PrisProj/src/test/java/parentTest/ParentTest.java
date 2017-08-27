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

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitriy on 17.07.2017.
 */
//Аннотация для параметризированного запуска по класу в котором мы опишем с какими браузерами будм работать
@RunWith(value = Parameterized.class)

//Создаем обьекты страниц пейджей
public class ParentTest {
    public WebDriver webDriver; //Обьявили модификатором public чтобы был доступен в обоих package(инкапсуляция)
    private Logger logger = Logger.getLogger(getClass());
    private Utils utils = new Utils(); //Обьявили обьект для снятия скринов
    private String pathToScreenShot; //Переменная для изменяемого пути к файлу

    private String browser; //обьявили переменную для наследования
    public boolean isTestPass = false; //обьявили меременную для скрина что тест не прошел

    public LoginPage loginPage; //обьявили переменную loginPage
    public HomePage homePage; //обьявили переменную homePage
    public SparePage sparePage; //обьявили переменную sparePage
    public AddNewSparePage addNewSparePage;
    public ProvidersPage providersPage; //обьявили переменную providersPage
    public AddNewProvidersPage addNewProvidersPage;

    //Конструктор передает во внутрь класса, настроить обьект. передаем обьект с одного класса в другой
    //работай с обьектом этого класса
    //public ParentTest() {}

    //Создаем новый конструктор для параметризированного теста разных браузеров
    public ParentTest(String browser) {
        this.browser = browser; //слово this метод ссылатся на вызвавший его объект
    }

    //Аннотация которая дает понять методу что нужно запустить тесты на етих браузерах
    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return Arrays.asList(new Object[][]{
                //{"fireFox"},
                //{"chrome"},
                { "iedriver" },
                //{ "opera" },
                //{"phantomJs"}
        });
    }


    @Rule //аннотация  которая позволяет получить информацию о тесте который сейчас запущен и получить его имя
    public TestName testName = new TestName();

    @Before
    public void setUp() {
        //Мы создали обьект файлы без пути для того чтобы потом спросить нас о пути
        File file = new File("");

        //Для запуска разных браузерах/Логирование/Обращения к дравйверу
        if ("fireFox".equals(browser)) {
            logger.info("FireFox will be started ");
            File fileFF = new File(".././drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("marionette", true);
            webDriver = new FirefoxDriver(capabilities);
            webDriver.manage().window().maximize();
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
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            webDriver = new InternetExplorerDriver();
            logger.info(" IE is started");
        } else if ("opera".equals(browser)) {
            logger.info("Opera will be started");
            File fileOpera = new File(".././drivers/operadriver.exe");
            System.setProperty("webdriver.chrome.driver", fileOpera.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info(" Opera is started");
        } else if ("phantomJs".equals(browser)) {
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

        //Этот метод создает путь к папкам которые мы создали папку с именем , пекедж с именем, имя файла и его разширение
        pathToScreenShot = file.getAbsolutePath() + "\\target\\screenshot\\"
                + this.getClass().getPackage().getName() + "\\"
                + this.getClass().getSimpleName() + "\\"
                + this.testName.getMethodName() + "-" + browser + ".jpg";
        //+ this.testName.getMethodName() + ".jpg";

        //Эти строки работают для одного браузера chrome если не использовать переметризированный запуск
        //File fileGC = new File(".././drivers/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", fileGC.getAbsolutePath());
        //webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver); //Передали в loginPage webDriver с которым мы будем пользоваться
        homePage = new HomePage(webDriver); //Передали в homePage webDriver с которым мы будем пользоваться
        sparePage = new SparePage(webDriver);//Передали в sparePage webDriver с которым мы будем пользоваться
        addNewSparePage = new AddNewSparePage(webDriver);
        providersPage = new ProvidersPage(webDriver); //Передали в providersPage webDriver с которым мы будем пользоваться
        addNewProvidersPage = new AddNewProvidersPage(webDriver);
    }

    @After
    public void tearDown() {
        if (!(webDriver == null)) { //Если дравера нету но ничего закрывать
            if (!isTestPass) {
                //Только в случаи false если тест упадет
                utils.screenShot(pathToScreenShot, webDriver); //при каждом закрытии драйвера снимать скрин
            }
            //webDriver.quit();
        }
    }

    /**
     * @param message
     * @param actualResult
     * @param expectedResult
     */
    //Создаем метод Аксептес кретерии с типами и переменными для сравнение Фактического и Ожидаемого результата
    public void checkAC(String message, boolean actualResult, boolean expectedResult) {
        //делает сравнение actualResult с expectedResult заимпортим is - ALT+ENTER выбираем CoreMatchers
        //Assert.assertThat(message, actualResult, is(expectedResult));

        //Эсли actualResult == expectedResult дает false то делаем скрин
        if (!(actualResult == expectedResult)) {
            utils.screenShot(pathToScreenShot, webDriver);
            logger.error("AC failed: " + message);
        }
        Assert.assertThat(message + "Browser - " + browser + " ScreenShot " + pathToScreenShot, actualResult, is(expectedResult));

        setTestPass();
    }

    private void setTestPass() { //метод в эту переменную записует тру
        isTestPass = true;
    }
}