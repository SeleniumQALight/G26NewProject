package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger( getClass() );
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
            element.sendKeys( text );
            logger.info( text + " was inputed" );
        } catch (Exception e) {
            logger.error( "Can't work with element" + element );
            Assert.fail( "Can't work with element" + element );
        }
    }

    public void mouseClickElement(WebElement element) {
        try {
            element.click();
            logger.info( "Element " + element + " was clicked" );
        } catch (Exception e) {
            logger.error( "Can't work with element" + element );
            Assert.fail( "Can't work with element" + element );
        }
    }

    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement( By.xpath( locatorWithText ) ).isDisplayed();

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
