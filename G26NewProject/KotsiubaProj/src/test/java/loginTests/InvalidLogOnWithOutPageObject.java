package loginTests;

import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.By;

import parrentTest.ParrentTest;

/**
 * Created by Нов on 17.07.2017.
 */
public class InvalidLogOnWithOutPageObject extends ParrentTest {

    public InvalidLogOnWithOutPageObject() {

    }

    @Test
    public void invalidLogOn() {
        // и у этого есть метод .openLoginPage();
        loginPage.openLoginPage();
        // заменяем это строкой
        //webDriver.get("http://v3.qalight.com.ua/login"); -> loginPage.openLoginPage();

        //  выделяем enterLoginToInput alt+enter - create method в LoginPage
        loginPage.enterLoginToInput("Student");
        //webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");

        loginPage.enterLoginToInput("2222");
//        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("2222");


        // тут он уже используеться
        loginPage.clickOnSubmitButton();
        //         webDriver.findElement(By.xpath(".//button[@type='submit']")).click();


// потом на isElementWithTextPresent создаем метод
        checkAC("Text 'Учет запчастей' not found", loginPage.isElementWithTextPresent("Учет запчастей")
        //checkAC("Text 'Учет запчастей' not found", webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed(), true);
                , true
        );
// переносим это в ParrentPage так как проверка для всего теста что мы залогились
        //       Assert.assertTrue(webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());
    }
}
