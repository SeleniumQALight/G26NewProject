package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Kleine-Hexe on 20.07.2017.
 */
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) { //это конструктор
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method clears and enters text to webElement
     *
     * @param element
     * @param text
     */
    public void enterText(WebElement element, String text) {//это метод, который будет вводить текст в элементы, которые мы передадим
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered");
        } catch (Exception e) {
            logger.error("Cannot work with element " + element);
            Assert.fail("Cannot work with element " + element);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("element was clicked on");
        } catch (Exception e) {
            logger.error("Cannot work with element " + element);
            Assert.fail("Cannot work with element " + element);
        }
    }

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