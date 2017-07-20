package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParrentPage {
    // Для кадого мы прописуем FindBy
    @FindBy(name = "_username")
    // это строка создает обьект вебелмент ( т.е. 1 строка что то ищет,а 2 создает)
    private WebElement loginInput;


    // Дописуем пусть id = "password" ( Это то что мы должны найти)
    @FindBy(id = "password")
    private WebElement inputPass;


    @FindBy(xpath = ".//button")
    // Object заменяем на WebElement И делаем @FindBy
    private WebElement buttonSubmit;

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
     *
     * @param login
     */
    public void enterLoginToInput(String login) {
        // все нижнее мы заменяем этой одной строкой
        actionsWithOurElements.enterText(loginInput, login);
//        try {
//            // этот инпут как обьект
//            loginInput.sendKeys(login);
//            logger.info(login + "was inputed into Input Login");
//        } catch (Exception e){
//            logger.error("Can not with input");
//            Assert.fail("Can not with input");
//        }

    }
    // метод который будет вводить в пассворd

    public void enterPassWordToInput(String passWord) {
        // inputPass + alt Enter - field
        // потом идем на верх и пишем файндБу
        actionsWithOurElements.enterText(inputPass, passWord);
    }


    // метод клика на ПРИМЕНИТЬ кнопку
    public void clickOnSubmitButton() {
        // buttonSubmit -> alt+enter

        // потом на clickOnElement - создать метод
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    public boolean isElementWithTextPresent(String text) {
//text - это параметр
        // ".//*[contains(text(),'"+text+"')]" - поиск любого передаваемого текста на странице
        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'"+text+"')]");
    }
}
