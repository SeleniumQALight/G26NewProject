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

/**
 * Created by Asus on 20.07.2017.
 */
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;

    public ActionsWithOurElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 15);// ждет 15 секунд проверяя каждые 0.5 секунд.
    }

    /**
     * Method clears and inputs text to webelement
     *
     * @param element
     * @param text
     */
    public void enterText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted");

        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("element was clicked ");
        } catch (Exception e) {
            logger.info("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
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
        try{
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public void checkTextinElement(String xPath ,String text){
            try{
                webDriverWait15.until(ExpectedConditions.textToBePresentInElement(By.xpath(xPath),text));
                String textFromElement = webDriver.findElement(By.xpath(xPath)).getText();
                Assert.assertThat("Text in element not matched",textFromElement,is( text));
            }catch (Exception e) {
                logger.info("Can not work with element");
                Assert.fail("Can not work with element");
            }
    }

    public void selectTextInDDbyText(WebElement dropDown, String text) {
        try{
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByVisibleText(text);
            logger.info(text + " was selected in dropdown");

        }catch (Exception e){
            logger.info("Can not work with DropDown");
            Assert.fail("Can not work with DropDown");
        }
        //public void selectTextInDDbyValue (WebElement dropDown, String text){

    }

    }

