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
import pages.LoginInPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is; // импортили is

public class ParentTest {
    public WebDriver webDriver; // объявили объект -браузера
    private Logger logger = Logger.getLogger(getClass());
    public LoginInPage loginInPage;
    private Utils utils = new Utils();
    private String pathToScreenShot;

    public HomePage homePage;
    public ParentTest() {
    }
    @Rule
    public TestName testName = new TestName(); // получает информацию о тесте который сейчас запущен, дает имя его.

    @Before
    public void setUp(){
        File file = new File(""); // создали файл, внутри нашего проектв,  без пути
        pathToScreenShot = file.getAbsolutePath() + "\\target\\screenshots"
                + this.getClass().getPackage().getName() + "\\"
                + this.getClass().getSimpleName() + "\\"
                + this.testName.getMethodName() + ".jpg";
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath()); // этот путь нужен чтоб браузер знал от куда стартовать
        webDriver = new ChromeDriver(); // тут откроется браузер, это как и команда ему открыться
        webDriver.manage().window().maximize(); // тут мы изменяем размер экрана до максимального
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // задаем время ожидания. наш браузер будет на протяжении 10с искать логин -элемент, если не найдет за 10с то будет ексепшин
        loginInPage = new LoginInPage(webDriver); // создан объкт LoginInPage и передает параметры : webDriver = new ChromeDriver
    }
    @After

    public void tearDown(){ // закрытие вкладки и сам браузер+скриншот, даже если тест не прошел
          if (!(webDriver==null)) {
              utils.screenShot(pathToScreenShot,webDriver);
               webDriver.quit();
    }

    }
    public void checkAC(String massage, boolean actualResult, boolean expectedResult){ // проверка результата в тестах
        // Assert.assertThat(massage,actualResult,is(expectedResult)); //
    }


}
