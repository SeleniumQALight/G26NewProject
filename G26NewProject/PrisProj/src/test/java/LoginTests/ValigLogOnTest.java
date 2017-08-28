package LoginTests;

import parentTest.ParentTest;
import org.junit.Test;

/**
 * Created by Dmitriy on 24.07.2017.
 */

public class ValigLogOnTest extends ParentTest {

    //Конструктор - используй вебдрайвер обьект который обьявлен в родителе.
    //public ValigLogOnTest() {}
    //Создаем новый конструктор для параметризированного теста разных браузеров
    public ValigLogOnTest(String browser) {
        super(browser);
    }

    @Test
    //@Ignore //аннотация которая игнорит 1 тест кейс
    public void validLogOn() {
        loginPage.openLoginPage(); //сюда ничего передавать не нужно
        loginPage.enterLoginToInput("Student"); //Логины могут быть разные
        loginPage.enterPasswordToInput("909090"); //Может передавать разные пароли
        loginPage.clickOnSubmitButton(); //Кликнить по кнопке
        checkAC("Avatar is not present on Page",
                homePage.isAvatarPresent(),
                true);
    }
}