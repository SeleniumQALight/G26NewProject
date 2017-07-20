package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    public LogInPage logInPage;

    public ParentTest() {

    }


    @Before //полностью подготавливаем браузер к работе
    public void setUp() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());


        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logInPage = new LogInPage(webDriver); // открой браузер и с ним работай.
    }

    @After //прописываем что делать после прогона тестов
    public void tearDown() {
        webDriver.quit();


    }
    public void checkAC (String massage,boolean actualResult, boolean expectedResult){ //АС - аксептанс критерия

        Assert.assertThat(massage,actualResult,is(expectedResult)); //заимпортить alt+enter
    }

}
