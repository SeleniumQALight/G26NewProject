package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by admin on 19.07.2017.
 */
public class LogInPage extends ParentPage {
    /**
     * @findBy ищет элемент по его признаку: имя, xpath(если xpath тгда писать его полностью)
     * WebElement создает объект того что нашли
     * Они ходят ВСЕГДА вместе!!!ы
     */
    @FindBy(name = "_username")
    private WebElement loginInput;

    @FindBy(id = "password")
    //все аннотации работают ТОЛЬКО с методами которые идут за ними!!!!
    //сначала он ищет элемент, потом создает объект!!!
    private WebElement inputPass;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonSubmit;

    /**
     * public LogInPage - это конструктор метода.
     * конструктор в классе может быть ТОЛЬКО один, он настраивает метод в классе.
     * Конструктор от метода отличается написанием с большой буквы, тогда как метод пишется с маленькой
     **/
    public LogInPage(WebDriver webDriver) {
        //super - это обращение к parent
        /**
         все мои комментарии здесь я пушу в Гитхаб, чтобы их удалить из проекта
         --> нужно удалить комментарии локально и запушить еще раз
         Static методы, переменные возникают до начала программы, умирают после окончания программы
         Как обойти capture:
         - попросить девов отключить ее на тестовом окружении
         - попросить девов написать сервис для отключения
         - использовать киттайские фермы: стоит денег
         - использовать робота из инета который рукой вводит
         **/
        super(webDriver);
    }

    public void openLoginPage() {
        open("http://v3.qalight.com.ua/");

    }

    /**
     * method login into 'Login' prompt
     *
     * @param login
     */
    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText(loginInput, login);
//        try {
//            //webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys(login);
//            //вместо этого пишем
//            loginInput.sendKeys(login);
//            logger.info(login + " was accepted as a valid login");
//      } catch (Exception e) {
//          logger.error("Cannot accept login input");
//           Assert.fail("Cannot accept login input");

    }

    public void enterPassWordToInput(String passWord) {
        //в методах: название метода.что сделать (куда, что)
        actionsWithOurElements.enterText(inputPass, passWord);
    }

    public void clickOnSubmitButton() {
        //параметры для вывода методу не пишем потомучто он просто кликает
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    public boolean isElementWithTextPresent(String text) {

        return actionsWithOurElements.isElementPresent(".//*[contains (text (),'" + text + "')]");
    }
}

