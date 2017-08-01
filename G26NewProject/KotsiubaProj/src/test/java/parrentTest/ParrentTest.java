package parrentTest;

import libs.Utiles;
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

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Нов on 17.07.2017.
 */
public class ParrentTest {
    public WebDriver webDriver;
    // добавили в public что б LoginPage loginPage был виден везде
    public LoginPage loginPage;
    // Обьявляем HomePage
    public HomePage homePage;

    // тут обьявляем переменную которую будем использовать
public SparePage sparePage;

    public AddNewSparePage addNewSparePage;
    // обьявляем дл СКРИНШОТОВ:
    // мы обьявили логгер чтто б снизу его использовать в скриншотах
    // getLogger - мы достаем с библиотеки ( это вместо System.out.println - мы используем)
    private Logger logger = Logger.getLogger(getClass());

    // создаем обьект утилс
    private Utiles utiles = new Utiles();

    // просто обьявлем стринговую переменную, тут будет содержаться изменяемый путь к файлам
    private String pathToScreenShot;


    // Если тест прошел - нам скриншот не нужен
    private boolean isTestPass = false;





    public ParrentTest() {
    }

    // с помощью Junit
    // благодаря @Rule Junit знает что это нужно выполнить
@Rule
public TestName testName = new TestName();



    @Before
    public void setUp() {
        // абсолютный путь к нашему проекту. Мы создали обьект файлика, без указания пути где он находиться. Этот путь будет всегда меняться
        File file = new File("");
        // прописуем пусть сохранения: в папке Таргет создаться скриншот в ней соритироваться имя пекедж - имя класа - потом имя тест кейчас
        pathToScreenShot = file.getAbsolutePath() + "\\target\\screenshots\\" + this.getClass().getPackage().getName() + "\\" + this.getClass().getSimpleName() + "\\" + this.testName.getMethodName() + ".jpg";


        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        // webDriver - это интфейс описывающий работу с браузерами
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        // создаем обьект
        sparePage = new SparePage(webDriver);

        // Добавляем новую пейджу
        addNewSparePage = new AddNewSparePage(webDriver);
    }

    @After
    public void tearDown() {
        //Дописуем. Если обьекта (драйвера нет) - то и нечего закрывать. Т.е. если он есть мы его закрываем
        if (!(webDriver == null)) {
            // дописуем только если скриншот завалился будет скриншот, без этой строки скриншот всегда
        }
            if (!isTestPass) {
            // дописуем скриншот!
            {
                utiles.screenShot(pathToScreenShot, webDriver);
                webDriver.quit();
            }
        }
    }


    // проверяем залоигинились или нет. Даем ему месседж который будет выведен и А.Р. и Е.Р.
    // Метод который проверят!!
    public void checkAC(String message, boolean actualResult, boolean expectedResult) {



        // import static org.hamcrest.CoreMatchers.is;
        // ПРОВЕРКА АКТУАЛЬНОГО РЕЗУЛЬТАТА ПОЭТОМУ ОН В ParrentTest - проверка актуального и ожидаемого результата
        Assert.assertThat(message, actualResult, is(expectedResult));
        // прописуем еще метод
        setTestPass();
    }
// метод проверки прохождение теста
    private void setTestPass() {
        isTestPass = true;
    }
}
