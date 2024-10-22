package LoginTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;//14.08
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTestWithOutPageObject {
    WebDriver webDriver; // объявили объеkт -браузера

    @Test
    public void  validLogOn() throws MalformedURLException { // validLogOn будет валидный тест кейс
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
       webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
               DesiredCapabilities.chrome());
        // webDriver = new ChromeDriver(); // это объект для реализации хром драйвера, тутмы открыли браузер но смаленьким экраном
        webDriver.manage().window().maximize(); // тут мы изменяем размер экрана до максимального
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // задаем время ожидания. наш браузер будет на протяжении 10с искать логин -элемент, если не найдет за 10с то будет ексепшин
        webDriver.get("http://v3.qalight.com.ua/");//get метод вставляет наш url в строку браузера
        System.out.println("Page was opened/"); // что мы знали что страница открылась
        webDriver.quit(); // закрытие вкладки и сам браузер

    }
}
