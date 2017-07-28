package loginTests;

import org.junit.Test;
import parrentTest.ParrentTest;

public class validLogOnTest extends ParrentTest{
    // создаем тест
    @Test
    public void validLogOnTest(){
loginPage.openLoginPage();
// Мы передаем студент, потому что логины у всех разные (также и пароль)
loginPage.enterLoginToInput("Student");
loginPage.enterPassWordToInput("909090");
loginPage.clickOnSubmitButton();
// тут метод (homePage.isAvatarPresent) пишем, так как его еще нету
        // После манипуляций с homePage , правой кнопкой на метод isAvatarPresent - создать метод в папке HomePage
checkAC("Avatar is not present on page", homePage.isAvatarPresent(), true);

    }
}
