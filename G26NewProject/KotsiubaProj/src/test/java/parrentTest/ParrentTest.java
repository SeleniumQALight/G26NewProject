package parrentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

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
    public ParrentTest() {
    }


    @Before
    public void setUp() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        // webDriver - это интфейс описывающий работу с браузерами
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }


    // проверяем залоигинились или нет. Даем ему месседж который будет выведен и А.Р. и Е.Р.
    // Метод который проверят!!
    public void checkAC(String message, boolean actualResult, boolean expectedResult) {
        // import static org.hamcrest.CoreMatchers.is;
        // ПРОВЕРКА АКТУАЛЬНОГО РЕЗУЛЬТАТА ПОЭТОМУ ОН В ParrentTest - проверка актуального и ожидаемого результата
        Assert.assertThat(message, actualResult, is(expectedResult) );
    }
}
