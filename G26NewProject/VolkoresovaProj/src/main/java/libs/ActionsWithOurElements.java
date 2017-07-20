package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by tatyanavolkorezova on 20.07.17.
 */
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method clears and inputs text to webElement
     * @param element
     * @param text
     */
    public void enterText(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text+"was inputed");
        }catch(Exception e){
            logger.error("Can not work with element"+ element);
            Assert.fail("Page cannot opened"+ element);
        }



    }

    public void clickOnElement(WebElement element) {
        try{
            element.click();
            logger.info("Element was clicked");

        }catch(Exception e){
            logger.error("Can not work with element"+ element);
            Assert.fail("Page cannot opened"+ element);
        }

    }

    public boolean isElementPresent(String locatorWithText) {
        try{
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();

        }catch(Exception e){
            return false;
        }

    }
}
