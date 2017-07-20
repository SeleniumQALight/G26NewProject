package LoginTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import parentTest.ParentTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class InvalidLogOnWithOutPageObject extends ParentTest {
    WebDriver webDriver;

    public InvalidLogOnWithOutPageObject(WebDriver webDriver) { // это конструтор, мы его создали после того как создали консрукторв в Parent. Для создания его тут, надо навести курсор на имя метода и Alt+enter
        super(webDriver);// это вебдрайвер которотый мы будем использовать тут со всеми свойствами что указаны в Parent
    }

    @Test
        public void invalidLogOn(){
        webDriver.get("http://v3.qalight.com.ua/");//get метод вставляет наш url в строку браузера
        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//*[@id='password']")).sendKeys("2222");
        webDriver.findElement(By.xpath(".//button")).click();
        Assert.assertTrue(webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());//метод валидации , сверяет актуальный результат с ожидаемым
    }


}




