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

import static org.hamcrest.core.Is.is;

/**
 * Created by romas on 17.07.2017.
 */
public class ParentTest { //надо создать конструктор. Выбираем имя класса чтоб курсор мигал => Альт + Инсерт => конструктор
    //конструктор нужен для того чтоб настроить объкт. Конструктор ниже public ParentTest(WebDriver webDriver) {
    //this.webDriver = webDriver;
    public WebDriver webDriver;  // не забывать модификатор доступа
    private Logger logger = Logger.getLogger(getClass());
    private Utils utils = new Utils();
    private String pathToScreenShot; // создае переменную которая будет указывать изменяемый путь к файлу

    public LogInPage logInPage;
    public HomePage homePage;

    public ParentTest() {

    }

    @Rule
    public TestName testName = new TestName(); //будет получать инфо о тесте который мы сейчас запустим


    @Before //полностью подготавливаем браузер к работе
    public void setUp() {
        File file = new File(""); //создали объект файла без указания пути где он лежит для того чтоб потом спросить путь где он лежит на диске
        pathToScreenShot = file.getAbsolutePath()
                + "\\target\\screenshots\\" // создаются папки если нет
                + this.getClass().getPackage().getName() //папка с именем пекеджа
                + "\\" //два слеша из-за экранирования джавы
                + this.getClass().getSimpleName() //папка с именем класса
                + "\\"
                + this.testName.getMethodName()//файл.дай свой абсолютный путь. создай папки.
                + ".jpg";
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());


        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logInPage = new LogInPage(webDriver); // открой браузер и с ним работай.
        homePage = new HomePage(webDriver);
    }

    @After //прописываем что делать после прогона тестов
    public void tearDown() {
        if (!(webDriver == null)) {  //закрываем драйвер если он не null - В том случае если мы просим закрыть то чего уже нет. Если вебдрайвер уже ранее был убит
            utils.screenShot(pathToScreenShot,webDriver);//снимаем скрин если драйвер живой
            webDriver.quit();


        }
    }

    public void checkAC(String massage, boolean actualResult, boolean expectedResult) { //АС - аксептанс критерия

        Assert.assertThat(massage, actualResult, is(expectedResult)); //заимпортить alt+enter
    }

}
