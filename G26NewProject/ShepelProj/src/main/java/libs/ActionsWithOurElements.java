package libs;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;


public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 15); // создали объект по переменной webDriverWait15 на ожидание 15 сек.
    }

    /**
     * Method clears and inputs text to webElement
     * @param element
     * @param text
     */
    public void enterText(WebElement element, String text){
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted");
        }catch (Exception e){
            logger.error("Can not work with element " + element);
            Assert.fail("Can not work with element " + element);
        }
    }

    public void clickOnElement(WebElement element) {
        try{
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("element was clicked");
        }catch (Exception e){
            logger.error("Can not work with element " + element);
            Assert.fail("Can not work with element " + element);
        }
    }

    public boolean isElementPresent(String locatorWithText) {
        try{
            return webDriver.findElement(By.xpath(locatorWithText))
                    .isDisplayed();
        }catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try{
            return element.isDisplayed();
        }catch (Exception e) {
            return false;
        }
    }

    public void checkTextInElement(String xPath, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.textToBePresentInElement(By.xpath(xPath),text));
            String textFromElement = webDriver.findElement (By.xpath(xPath)).getText();
            Assert.assertThat("Text in Element not matched", textFromElement, is(text)); // метод is импортим Core Matchers
        } catch (Exception e){
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element ");
        }
    }

    public void selectTextInDDByText(WebElement dropDown, String text) {
        try {
            Select optionsFromDD = new Select (dropDown); // библиотека Select умеет работать с дропдауном
            optionsFromDD.selectByVisibleText(text);
            logger.info(text + " was selected in DropDown");
        } catch (Exception e){
            logger.error("Can not work with DropDown ");
            Assert.fail("Can not work with DropDown ");
        }

    }
}
