package LoginTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 13.07.2017.
 */
public class LoginTestWithOutPageObject {
    //создаем обьект браузер
    //обьявили переменную
    WebDriver webDriver;

    @Test //аннотацию junit
    public void validLogOn() throws MalformedURLException {
        //эта надпись нужно для того чтобы указать путь к файлу chromedriver для работы с ним
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

        //создали обьект ChromeDriver для работы с ним //ChromeDriver - это реализация webDriver
        //открыли браузер в маленьком размере
        //webDriver = new ChromeDriver();
        //webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        // Менеджеру webDriver дали команды открыть браузер в макс размере
        webDriver.manage().window().maximize();

        //настроить дефолтное ожидание браузера при выполнении
        //браузер будет повторять действия которые мы задаем в течении 10 секунд, если не выполнит выведет ошибку
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Вствляет URL в адресную строку браузера
        webDriver.get("http://v3.qalight.com.ua");

        //Найди мне елемент по xpath -> указать локатор и всттавь мне данные(sendKeys) в поле
        webDriver.findElement(By.xpath(".//input[@class='form-control' and @placeholder='Email']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@class='form-control' and @placeholder='Password']")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[text()='Вход']")).click();
        webDriver.findElement(By.xpath(".//h1"));
        webDriver.findElement(By.xpath(".//li[@class='dropdown user user-menu']")).click();
        webDriver.findElement(By.xpath(".//div[2][@class='pull-right']//a[@href='/logout']")).click();
        System.out.println("Page was opened");

        //Дать команду webDriver -> close - закрывает вкладку quit - закрывает браузер
        //webDriver.quit();

    }
}
