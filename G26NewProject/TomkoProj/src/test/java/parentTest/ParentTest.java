package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginInPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is; // импортили is

public class ParentTest {
    public WebDriver webDriver; // объявили объеkт -браузера
    public LoginInPage loginInPage; //public-чтобы мы могли использовать в тестах других пакетов, тут : оьъявили объет loginInPage для использования в тестах

    public ParentTest() {
    }

    @Before
    public void setUp(){
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath()); // этот путь нужен чтоб браузер знал от куда стартовать
        webDriver = new ChromeDriver(); // тут откроется браузер, это как и команда ему открыться
        webDriver.manage().window().maximize(); // тут мы изменяем размер экрана до максимального
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // задаем время ожидания. наш браузер будет на протяжении 10с искать логин -элемент, если не найдет за 10с то будет ексепшин
        loginInPage = new LoginInPage(webDriver); // создан объкт LoginInPage и передает параметры : webDriver = new ChromeDriver
    }
    @After
    public void tearDown(){
        webDriver.quit(); // закрытие вкладки и сам браузер
    }
    public void checkAC(String massage, boolean actualResult, boolean expectedResult){ // проаерка результата в тестах
        // Assert.assertThat(massage,actualResult,is(expectedResult)); //
    }
}
