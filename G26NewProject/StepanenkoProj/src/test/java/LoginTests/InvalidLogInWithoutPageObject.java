package LoginTests;

import org.junit.Test;
import parentTest.ParentTest;

/**
 * Created by admin on 17.07.2017.
 */
public class InvalidLogInWithoutPageObject extends ParentTest {
    //webdriver - это браузер
    //это конструктор. Он настраивает объект, класс передавая настройки из суперкласса(Parent Class)
    //чтобы добавить конструктор: focus on class name+alt+enter+create construction
    public InvalidLogInWithoutPageObject() {
    }

    @Test
    public void invalidLogIn() {
        //вместо:
        //webDriver.get("http://v3.qalight.com.ua/");
        //используем
        logInPage.openLoginPage();

        //webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys("Student");
        //используем:
        logInPage.enterLoginToInput("Student");

        //вместо:
        //webDriver.findElement(By.xpath(".//*[@id='password']")).sendKeys("2222");
        //используем:
        logInPage.enterPassWordToInput("2222");

        //вместо:
        //webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        //используем:
        logInPage.clickOnSubmitButton();

        //is displayed - метод который показывает найдено ли такое сообщение
        //Asseert - библиотека которая сравнивает ER c AR -->
        //if TRUE = найдет
        //Assert(boolean type true-false)
        //если добавить !webDriver.findElement(By.xpath... - ! делает инвертацию = из true cделать false
        //Assert это acceptance criteria
        //Assert.assertTrue(webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());

        checkAC("Text 'Учет запчастей' not found",
                logInPage.isElementWithTextPresent("Учет запчастей")
//                webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']"))
//                        .isDisplayed()
                , true
        );
//        Assert.assertTrue("Assert work",webDriver.findElement(
//                By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());
    }

}
