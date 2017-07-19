package loginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Created by romas on 17.07.2017.
 */
public class InvalidLogOnWithOutPageObject extends ParentTest { //Альт + Ентер чтоб создать конструктор нашего класса


    public InvalidLogOnWithOutPageObject() {

    }


    @Test
    public void invalidLogOn() {
        webDriver.get("http://v3.qalight.com.ua/"); //если все кейсы на этой странице то можно вынести в прекондишины
        webDriver.findElement(By.xpath(".//*[@name='_username']"))
                .sendKeys("Student");
        webDriver.findElement(By.xpath(".//*[@id='password']"))
                .sendKeys("3455");
        webDriver.findElement(By.xpath(".//button")).click();
        Assert.assertTrue("Assert work", webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed()); //метод который спрашивает у драйвера нашел ли он элемент.
        //таким образом isDisplayed() делает выражением логически верным. Без него метод assertTrue не запустится тк мы просим найти элемент по xPath
        //те может быть что он не найдет. Нет булена
        //Assert.assertTrue(!webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed()); // можем сделать инвертацию. Должно быть фолс. Тогда тест упадет
        //сделали как буд-то этого текста нет
        //чтоб вывести текст надо первым параметром асерта написать запятую а перед ней в ковычках текст и идея сама подтянет message:

    }
}