package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.Is.is;

/**
 * Created by Оля on 20.07.2017.
 */
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15; //Set up waiting 15 seconds

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 15);
    }

    /**
     * Method clears and inputs text to webElement
     *
     * @param element
     * @param text
     */
    public void enterText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was entered");
        } catch (Exception e) {
            logger.error("Can not work with element " + element);
            Assert.fail("Can not work with element " + element);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info(element + " element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element " + element);
            Assert.fail("Can not work with element " + element);
        }
    }

    public void clickOnElement(String lokator) {
        try {
            WebElement element = webDriver.findElement(By.xpath(lokator));
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element ");
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
        } catch (Exception e) {
            return false;
        }
    }

    public void checkTextInElement(String xPath, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xPath), text));
            String textFromElement = webDriver.findElement(By.xpath(xPath)).getText();
            Assert.assertThat("Text in element not matched", textFromElement, is(text));
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void selectTextInDDByText(WebElement dropDown, String text) {
        try {
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByVisibleText(text);  //Better to work with the value, not with the text
            logger.info(text + " was selected in Drop Down");
        } catch (Exception e) {
            logger.error("Can not work with Drop Down");
            Assert.fail("Can not work with Drop Down");
        }
    }

    public void selectTextInDDByValue(WebElement dropDown, String value) {
        try {
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByValue(value);
            logger.info(value + " was selected in Drop Down");
        } catch (Exception e) {
            logger.error("Can not work with Drop Down");
            Assert.fail("Can not work with Drop Down");
        }
    }

    public void setCheckBoxToSelected(WebElement checkBox) {
        try {
            Boolean statusCheckBox = checkBox.isSelected();
            if (statusCheckBox) {
                logger.info("check box is initially checked");
            } else {
                webDriverWait15.until(ExpectedConditions.elementToBeClickable(checkBox));
                checkBox.click();
                logger.info("check box was clicked");
            }
        } catch (Exception e) {
            logger.error("Can not work with element " + checkBox);
            Assert.fail("Can not work with element " + checkBox);
        }
    }

    public boolean isFieldEmpty(WebElement element) {
        try {
            logger.info(element + " is empty");
            return element.getAttribute("value").equals("");

        } catch (Exception e) {
            logger.error("Can not work with field");
            Assert.fail("Can not work with field");
            return false;
        }

    }

    public String getTextFromElement(String xPath) {
        try {
            String textFromElement = webDriver.findElement(By.xpath(xPath)).getText();
            return textFromElement;
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
            return "";
        }
    }
}

