package pages;

import libs.ActionsWithOurElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by romas on 19.07.2017.
 */
public class LogInPage extends ParentPage {

    @FindBy(name = "_username") //пытаемся что-то найти по какому-то признаку
    private WebElement loginInput; // эти две строки ходят парой. Первая указывает что надо найти что-то по признаку.
    // Во второй то что нашли в первой записывает во вторую как объект


    @FindBy(id = "password")
    private WebElement inputPass;


    @FindBy(xpath = ".//button")
    private WebElement buttonSubmit;


    public LogInPage(WebDriver webDriver){ //вебрайвер передаем сюда. Все классы будут работать с одним браузером
        super(webDriver); //супер это обращение к родителю
    }

    public void openLoginPage (){

    open("http://v3.qalight.com.ua/");
    }

    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText(loginInput,login);
        /*        try {
            loginInput.sendKeys(login); // заменяем нижний метод.
            //webDriver.findElement(By.xpath("./[@name='_username']")).sendKeys(login); // передаем параметр логина который мы объявляли в enterLoginToInput
                    //заменено на вышестоящее
            logger.info(login + " was set into Input Login");
        }catch (Exception e){
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    */}

    public void enterPasswordToInput (String password){
        actionsWithOurElements.enterText(inputPass,password);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit); // нет метода clickOnElement и параметра buttonSubmit. Создаем через альт + ентер
    }

    public boolean isElementWithTextPresent(String text) {

        return actionsWithOurElements.isElementPresent(".//*[contains(text,'"+text+"')]"); // разделили наш локатор. Икспас универсальный.
    }
}
