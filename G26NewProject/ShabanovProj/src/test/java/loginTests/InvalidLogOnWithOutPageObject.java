package loginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LogInPage;
import parentTest.ParentTest;

/**
 * Created by romas on 17.07.2017.
 *
 * Метод который вставляет логин в поле логина
 *
 */
public class InvalidLogOnWithOutPageObject extends ParentTest { //Альт + Ентер чтоб создать конструктор нашего класса


    public InvalidLogOnWithOutPageObject() {

    }


    @Test
    public void invalidLogOn() {

        logInPage.openLoginPage();
        logInPage.enterLoginToInput("Student"); //создает объект через альт ентер в логин пейдже


        //webDriver.get("http://v3.qalight.com.ua/"); //если все кейсы на этой странице то можно вынести в прекондишины. Заменена на вышестоящую
        //webDriver.findElement(By.xpath(".//*[@name='_username']"))
        //        .sendKeys("Student");
        logInPage.enterLoginToInput("2222"); // заменили нижестоящий методом
        //webDriver.findElement(By.xpath(".//*[@id='password']"))
        //        .sendKeys("3455");

        logInPage.clickOnSubmitButton(); //через альт + ентер создаем метод в логин пейдж
                                        //заменяем нижестоящий метод
        //webDriver.findElement(By.xpath(".//button")).click();

        checkAC("Text 'Запчастей' not found",
                logInPage.isElementWithTextPresent("Учет запчастей"),true); // создаем метод isElementWithTextPresent через альт ентер
        //webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed(),true); //аксептанс критерии
                //закоментили часть и заменили вышестоящим методом

        //перенесли в ПарентТест
        Assert.assertTrue("Assert work", webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed()); //метод который спрашивает у драйвера нашел ли он элемент.
        //таким образом isDisplayed() делает выражением логически верным. Без него метод assertTrue не запустится тк мы просим найти элемент по xPath
        //те может быть что он не найдет. Нет булена
        //Assert.assertTrue(!webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed()); // можем сделать инвертацию. Должно быть фолс. Тогда тест упадет
        //сделали как буд-то этого текста нет
        //чтоб вывести текст надо первым параметром асерта написать запятую а перед ней в ковычках текст и идея сама подтянет message:

    }
}