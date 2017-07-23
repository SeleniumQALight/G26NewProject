package LoginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;



public class InvalidLogOnWithOutPageObject extends ParentTest {


    public InvalidLogOnWithOutPageObject() {

    }
    @Test
        public void invalidLogOn(){

        loginInPage.openLoginPage();
      //   этот метод заменяет эту строку webDriver.get("http://v3.qalight.com.ua/");//get метод вставляет наш url в строку браузера

        loginInPage.enterLoginToInput("Student");
       // webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");
       // заменили на строку loginInPage.enterLoginToInput("Student");
        webDriver.findElement(By.xpath(".//*[@id='password']")).sendKeys("2222");

        webDriver.findElement(By.xpath(".//button")).click();
        checkAC("Text 'Учет запчастей' not found",webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed(),true);
        // Assert.assertTrue(webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());//метод валидации , сверяет актуальный результат с ожидаемым
    }


}




