package LoginTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by shepel_av on 13.07.2017.
 */
public class LoginTestWithOutPageObject {
    WebDriver webDriver;
    @Test
    public void validLogOn() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver(); // создаем объект для драйвера
        webDriver.manage().window().maximize(); // откроет окно в максимальном размере браузера
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //браузер будет искать элемент и выполнять действие 10 секунд не упадет с эксепшином
        webDriver.get("http://v3.qalight.com.ua/"); // getString
        System.out.println("Page was opened"); // пока просто выводим в консоль без лога
        webDriver.quit(); //  webDriver.close() закрывает вкладку и браузер остается, а webDriver.quit() закрывает браузер

    }
}
