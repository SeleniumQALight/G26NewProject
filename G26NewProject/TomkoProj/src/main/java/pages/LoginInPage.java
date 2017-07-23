package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginInPage extends ParenPage {
    @FindBy(name = "username") // в () указываем по каким признакам будем искать (name, xpath)
    WebDriver loginInput; //эти две строки всегда парой, все что наша первая строка она записывает в эту переменную loginInput как объкты

    public LoginInPage(WebDriver webDriver) { //конструктор, тут: в LoginInPage -передаем webDriver с теста
        super(webDriver); //  а эта строка передаст этот же вебдрайвер в ParenTest
    }                      //т.е через все классы должен пройти один и тот же webDriver

    public void openLoginPage(){// в парамитрe ничего не должно быть ,он будет открывать свой url
        open("http://v3.qalight.com.ua/");// это метод которым создан в ParentPage
    }

    /**
     * Method input login to input
     * @param login
     */
    public void enterLoginToInput(String login) {
        try{
            webdriver.findElement(By.xpath(".//*[@name='_username']"))
                    .sendKeys(login);
            logger.info(login + "was inputed into Input Login"); //метод enterLoginToInput, научили обрабатывать Exception и ссобщать в лог, и assert сесли подребуется остановит тест и сообщит об этом

        }catch (Exception e){
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }
}