package loginTests;

import org.junit.Test;
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
        webDriver.manage().window().maximize(); // говорим вебдрайвер. У тебя есть управленец(менеджер).Нас интересует окно. Дай максимальный размер
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
     @Test
    public void inValidLogOn(){
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Stedent");
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("qwerty123");
        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-block btn-flat']")).click();
        System.out.println("Page was not opened");
        webDriver.quit();
    }
    @Test
    public void ValidLogOnAndExit(){
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("909090");
        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-block btn-flat']")).click();
        webDriver.findElement(By.xpath(".//a[@class='dropdown-toggle']")).click();
        webDriver.findElement(By.xpath(".//a[@href='/logout']")).click();
        System.out.println("Valid LogIn and Exit");
        webDriver.quit();
    }
}