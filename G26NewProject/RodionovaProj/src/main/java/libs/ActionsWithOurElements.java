package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Yuliya_Rodionova on 7/20/2017.
 */
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    public ActionsWithOurElements(WebDriver webDriver) {
            this.webDriver = webDriver;
            logger = Logger.getLogger(getClass());
    }

    public void enterText(WebElement element, String text){
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted");

        }catch (Exception e){
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }

    }

    public void clickOnElement(WebElement element) {
        try{
            element.click();
            logger.info( "element was clicked");

        }catch (Exception e){
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    public boolean isElementPresent(String locatorWithText) {
        try{
           return  webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();

        }catch (Exception e){
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try{
            return  element.isDisplayed();

        }catch (Exception e){
            return false;
        }
    }

    public void checkTextInElement(String xpath, String text){
        try{
            String textFromElement = webDriver.findElement(By.xpath(xpath)).getText();
            Assert.assertThat("Text in element is not matched",textFromElement,is(text));
        } catch (Exception e){
            logger.error("Can not work with text!");
            Assert.fail("Can not work with text!");
        }
    }
}
