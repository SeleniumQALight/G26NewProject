package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by romas on 20.07.2017.
 * Сюда будем выносить общие действия с нашими элементами
 * enterText - метод очищает и потом добавляет текст в ВебЕлемент
 *
 */
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;


    public ActionsWithOurElements(WebDriver webDriver) { //создаем конструктор. Сюда будем выносить общие действия с нашими элементами
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterText(WebElement element, String text) { //этот метод сможет вводить текст в любой елемент
        try {
            element.clear(); //элемент. почисти себя. Почисти поле для ввода
            element.sendKeys(text); //элемент. введи в себя текст который мы передали
            logger.info(text + " was added");

        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }


    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed(); //обращается к вебдрайверу.Просит найти элемент.И просит присутствует он или нет.
            //тут либо тру либо фолс
        } catch (Exception e) { // если элемента нет - тогда ловит ошибку и возвращает фолс
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch
            (Exception e){
                return false;
            }
        }
    }