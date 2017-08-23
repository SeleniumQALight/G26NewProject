package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Dmitriy on 20.07.2017.
 */
public class ActionWithOurElements { //В этот класс мы будем выносить все елементы страницы

    WebDriver webDriver;
    Logger logger;

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method clears and inputs text to webElement
     *
     * @param element
     * @param text
     */
    //Этот метод будет передавать елемент и текст который мы будем вводить
    public void enterText(WebElement element, String text) {
        try {
            element.clear(); //Почисти поле
            element.sendKeys(text); //Введи текст
            logger.info(text + " was inputted");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    /**
     * Method Click element Button
     *
     * @param element
     */
    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }

    }

    /**
     * Method is element with locator
     * @param locatorWithText
     * @return
     */
    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}