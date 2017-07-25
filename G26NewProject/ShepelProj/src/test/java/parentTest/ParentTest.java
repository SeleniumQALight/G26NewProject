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
        import pages.LogInPage;

        import java.io.File;
        import java.util.concurrent.TimeUnit;

        import static org.hamcrest.CoreMatchers.is;

public class ParentTest {
    public WebDriver webDriver;
    public LogInPage logInPage;
    public HomePage homePage;
    private Logger logger = Logger.getLogger(getClass());
    private Utils utils = new Utils(); // Добавляем метод для скриншота
    private String pathToScreenShot; // создаем переменную для пути к скриншоту

    public ParentTest() {

    }

    @Rule
    public TestName testName = new TestName();


    @Before
    public void setUp() {
        File file = new File(""); // создаем файл без указания пути, путь указываем строкой ниже
        pathToScreenShot = file.getAbsolutePath() + "\\target\\screenshot" // указывем путь к файлу и куда его нужно складывать
                + this.getClass().getPackage().getName() + "\\" // папка с именем пекеджа
                + this.getClass().getSimpleName() + "\\" + this.testName.getMethodName() + ".jpeg"; // папке с именем файла и расширением файла
        File fileFF = new File(".././drivers/chromedriver.exe"); // сдесь прописываем путь сразу
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logInPage = new LogInPage(webDriver);
        homePage = new HomePage(webDriver);
    }
    @After
    public void tearDown() {
        if (! (webDriver == null)) {
            utils.screenShot(pathToScreenShot, webDriver); // скриншот будет сниматься в любом случае, даже при "зелёных" тестах (иногда нужно на проекте
            webDriver.quit();
        }

    }

    public void checkAC(String message, boolean actualResult
            , boolean expectedResult){
        Assert.assertThat(message,actualResult,is(expectedResult));
    }
}