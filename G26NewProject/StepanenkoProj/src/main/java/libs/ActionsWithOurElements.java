package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by admin on 20.07.2017.
 */
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    // это конструктор класса, прописываем драйвер и логер, что и везде, чтобы с ним работать
    // конструктор передает что-то с чем работать, параметры метода.
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());

    }

    /**
     * Method Clears and inputs text into webelement (login prompt)
     *
     * @param element
     * @param text
     */
    // метод: введи текст --> куда: в WebElement --> какой: текстовый
    public void enterText(WebElement element, String text) {
        try {
            element.clear();
            //sendKeys - это команда "Ввести"
            element.sendKeys(text);
            logger.info(text + " was entered");
        } catch (Exception e) {
            logger.error("Cannot work with elemet" + element);
            Assert.fail("Cannot work with elemet" + element);
        }

    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("element was clicked");
        } catch (Exception e) {
            logger.error("Cannot work with elemet" + element);
            Assert.fail("Cannot work with elemet" + element);
        }
    }

    public boolean isElementPresent(String locatorWithText) {
        try {
            //webDriver попробуй найти элемент, если ОК - true
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();
            //усли не нашел false --> exception
        } catch (Exception e) {

            return false;
        }
    }
}


