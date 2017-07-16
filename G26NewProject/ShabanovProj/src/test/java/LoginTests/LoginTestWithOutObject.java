package LoginTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by romas on 13.07.2017.
 */
public class LoginTestWithOutObject {

    WebDriver webDriver;

    @Test
    public void validLogOn() {
        File fileFF = new File(".././drivers/chromedriver.exe");  // библиотека File дает возможность указывать путь к файлам через папки
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());   //setProperty системная переменная
        webDriver = new ChromeDriver(); //создали объект хромдрайвера. ChromeDriver реализация webDriver
        webDriver.manage().window().maximize(); // говорим вебдрайвер. У тебя есть управленец(менеджер).Нас интересует окно. Дай максимальній размер
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // тут говорим. Вебдрайвер. Обращаемся к управленцу.
        // Нас интересует чтоб наш браузер в течении 10с повторял действие.
        //По истичению 10с он даст ексепшен
        //Дефолтное ожидание

        webDriver.get("http://v3.qalight.com.ua/"); // берет и вставляет нащ урл в адресную строку
        System.out.println("Page was opened");
        webDriver.quit(); //close закрывает только вкладку. Quit закрывает браузер

        //вывести ниже в новый класс не валидный логин
        //webDriver.findElement(By.xpath("..//*[@name='_name']")).sendKeys("Student"); //sendKeys введи посимвольно
    }
}