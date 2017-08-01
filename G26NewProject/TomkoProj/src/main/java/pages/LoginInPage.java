package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; // FindBy имопорт

public class LoginInPage extends ParenPage {
    @FindBy(name = "_username")
    // в () указываем по какому признакам будем искать (name, xpath, id и т.д); после того как найдет его надо куда-то записать, это будет WebDriver loginInput; при импорте выбрать библиотеку (org.openqa.selenium.support)
    private WebElement loginInput; //эти две строки (WebElement+@FindBy) всегда создаються парой, все что @FindBy найдет loginInput записывает в эту переменную loginInput как объкты;

    @FindBy(id = "password")
    private WebElement inputPass;// его создал inputPass через alt+enter (выбрать field)

    @FindBy(xpath = ".//button")
    private WebElement buttonSubmit; //создаем элемент кнопка buttonSubmit

    public LoginInPage(WebDriver webDriver) { //конструктор, тут: в LoginInPage -передаем webDriver с теста
        super(webDriver); //  а эта строка передаст этот же вебдрайвер в ParenTest
    }                      //т.е через все классы должен пройти один и тот же webDriver

    public void openLoginPage() {// в парамитрe ничего не должно быть ,он будет открывать свой url
        open("http://v3.qalight.com.ua/");// это метод которым создан в ParentPage
    }

    /**
     * Method input login to input
     *
     * @param login
     */
    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText(loginInput, login);
//       try{
//           loginInput.sendKeys(); //webdriver.findElement(By.xpath(".//*[@name='_username']")) //этот объект мы описываем в @FindBy в начале класса
//                                 //.sendKeys(login);
//            logger.info(login + "was inputed into Input Login"); //метод enterLoginToInput, научили обрабатывать Exception и ссобщать в лог, и assert сесли подребуется остановит тест и сообщит об этом
//
//       }catch (Exception e){
//            logger.error("Can not work with input");
//            Assert.fail("Can not work with input");
//       }
    }

    public void enterPassWordToInput(String passWord) {
        actionsWithOurElements.enterText(inputPass, passWord);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit); // создан метод клик по сабмит
    }

    public boolean isElementWithTextPresent(String text) {//нажать ентер на все слова в красной рамке

        return actionsWithOurElements.isElementPresent(".//*[contains(text()," + text + ")]"); //
    }

    public void loginUser(String login, String password) {//2607 , создали метод loginUser
    openLoginPage(); //объявляем методы внутри этого метода, что он будет делать
    enterLoginToInput(login); //2607, объявляем методы внутри этого метода, что он будет делать
    enterPassWordToInput(password);//2607
    clickOnSubmitButton();
    ckeckTitle("Учет запчастей");
    }
}