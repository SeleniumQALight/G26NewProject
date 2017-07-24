package libs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    // создаем конструкто, что б в обьект передать параметр
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method clean and inputs to webElement
     *
     * @param element
     * @param text
     */
    // метод который будет вводить текст в любой инпут
    public void enterText(WebElement element, String text) {
        // предусмотреть внештатную ситуацию
        try {
            // тут мы непосредственно работаем с елементом
            element.clear();
            // введи в себя текс
            element.sendKeys(text);
            logger.info(text + "was inputted");
        } catch (Exception e) {
            logger.error("Cannot work with Element" + element);
            Assert.fail("Cannot work with Element" + element);
        }
    }

    // elment - потому что везде елементы будут использоваться
    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Clicked on element");
        }catch (Exception e) {
            logger.error("Cannot work with Element" + element);
            Assert.fail("Cannot work with Element" + element);
        }

    }

    // метод который ищет текст
    // два return потому что мы либо возвращаем тру либо фолс
    // isElementPresent -
    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
