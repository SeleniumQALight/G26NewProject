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
    public ActionsWithOurElements(WebDriver webDriver) { //это конструктор
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver,15);
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
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
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

    public void checkTextInElement(String xPath, String text) {
        try{
            webDriverWait15.until(ExpectedConditions.textToBePresentInElement(By.xpath(xPath),text));
            String textFromElement = webDriver.findElement(By.xpath(xPath)).getText();
            Assert.assertThat("Text in element does not match", textFromElement, is(text));
        }
        catch (Exception e) {
            logger.error("Cannot work with element " );
            Assert.fail("Cannot work with element ");
        }
    }

    public void selectTextInDDByText(WebElement dropDown, String text) {
        try{
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByVisibleText(text);
            logger.info(text + " was selected in DD");
        }catch (Exception e) {
            logger.error("Cannot work with DropDown " );
            Assert.fail("Cannot work with DropDown ");
        }
    }

    public void selectOptionInDDByValue(WebElement dropDown, String value) {
        try{
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByValue(value);
            logger.info("value " + value + " was selected in DD");
        }catch (Exception e) {
            logger.error("Cannot work with DropDown " );
            Assert.fail("Cannot work with DropDown ");
        }
    }

    public void checkCheckbox(WebElement checkbox){
        try {
            if(checkbox.isSelected()){
                logger.info("checkbox is already checked");
            }
            else{
                checkbox.click();
                logger.info("checkbox was checked");
            }
        } catch (Exception e) {
            logger.error("Cannot work with element " + checkbox);
            Assert.fail("Cannot work with element " + checkbox);
        }
    }
    public boolean checkTextInElementBoolean(String xPath, String text) {
        try{
            webDriverWait15.until(ExpectedConditions.textToBePresentInElement(By.xpath(xPath),text));
            String textFromElement = webDriver.findElement(By.xpath(xPath)).getText();
            //Assert.assertThat("Text in element does not match", textFromElement, is(text));
            return text.equals(textFromElement);
        }
        catch (Exception e) {
            logger.error("Cannot work with element " );
            //Assert.fail("Cannot work with element ");
            return  false;
        }
    }
}