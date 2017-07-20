package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParrentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);

    }

    // создаем метод, который нечего не возвращает, параметр не указуем так как может быть любой урл
    public void openLoginPage() {
// хотим использовать метод Parrent page
        // ctrl И наводим на open
        open("http://v3.qalight.com.ua/login");
    }
// второй метод, try, exeption e
    // enterLoginToInput  в папке LoginPage - так как работа с инпутом Логин - локальная!!!!!!!!!!
    // логика такак пробует найти елемент, если получилось написалось в лог что получилось, если нет то в лог что не вышло
    // и в assert что не вышло

    /**
     * mathod input login to input
     * @param login
     */
    public void enterLoginToInput(String login) {
        try {
            webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys(login);
            logger.info(login + "was inputed into Input Login");
        } catch (Exception e){
            logger.error("Can not with input");
            Assert.fail("Can not with input");
        }

    }
}
