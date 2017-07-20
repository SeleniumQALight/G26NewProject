package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    public WebDriver webDriver; // объявили объеkт -браузера

    public ParentTest() {
    }

    @Before
    public void setUp(){
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath()); // этот путь нужен чтоб браузер знал от куда стартовать
        webDriver = new ChromeDriver(); // тут откроется браузер, это как и команда ему открыться
        webDriver.manage().window().maximize(); // тут мы изменяем размер экрана до максимального
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // задаем время ожидания. наш браузер будет на протяжении 10с искать логин -элемент, если не найдет за 10с то будет ексепшин
    }
    @After
    public void tearDown(){
        webDriver.quit(); // закрытие вкладки и сам браузер

    }
}
