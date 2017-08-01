package LoginTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTestWithoutPageObject {
    private WebDriver webDriver;

    @Test
    // метод валидный догин
    public void validLogIn() {
        // путь к драйверу, где он находится
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        //объявление объекта драйвер=хром
        webDriver = new ChromeDriver();
        // команда хрому открыть браузер в полное расширение экрана
        webDriver.manage().window().maximize();
        //команда браузеру подождать дефолтное время ожидания на открытие сайта от 5-15 секунд (стандарт).
        //браузер будет повторять тест на протяжении 10 секунд, если найдет раньше - гуд, если позже,
        // будет exception. Если указано время. то не будет валится с exception раньше заданого времени
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //метод get.String s - браузер открывает страницу
        webDriver.get("http://v3.qalight.com.ua/");
        System.out.println("Page was opened");
        //метод close - закрывает вкладку, браузер открыт остается
        //метод quit - закрывает полностью браузер
        webDriver.quit();
    }
}

