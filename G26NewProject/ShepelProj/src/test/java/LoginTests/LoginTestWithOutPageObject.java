package LoginTests;

import org.junit.Test;
import org.openqa.selenium.By;
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
        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//*[@name='_password']")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        String baseUrl = "http://v3.qalight.com.ua/";
        String expectedTitle = "Учет запчастей";
        String actualTitle = "";
        webDriver.get(baseUrl); // запускаем браузер и перенаправляем его на базовый URL
        actualTitle = webDriver.getTitle(); // получаем title главной страницы после регистрации
        /*
         * сравниваем title полученной страницы с ожидаемым title и выводим в консоль результат
         * как "Passed" или "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        webDriver.quit(); //  webDriver.close() закрывает вкладку и браузер остается, а webDriver.quit() закрывает браузер

    }
    @Test
    public void invalidLogIn () {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua/");
        System.out.println("Page was opened");
        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("xxx");
        webDriver.findElement(By.xpath(".//*[@name='_password']")).sendKeys("xxx");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        String baseUrl = "http://v3.qalight.com.ua/";
        String expectedTitle = "Учет запчастей";
        String actualTitle = "";
        webDriver.get(baseUrl);
        actualTitle = webDriver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        webDriver.quit();

    }
}
