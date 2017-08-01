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
 * Created by tatyanavolkorezova on 20.07.17.
 */
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 15);
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
            logger.info(text+" was inputed");
        }catch(Exception e){
            logger.error("Can not work with element"+ element);
            Assert.fail("Page cannot opened"+ element);
        }



    }

    public void clickOnElement(WebElement element) {
        webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
        try{
            element.click();
            logger.info("Element was clicked");

        }catch(Exception e){
            logger.error("Can not work with element "+ element);
            Assert.fail("Page cannot opened" + element);
        }

    }

    public boolean isElementPresent(String locatorWithText) {
        try{
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();

        }catch(Exception e){
            return false;
        }

    }

    public boolean isElementPresent(WebElement element) {
        try{
            return element.isDisplayed();

        }catch(Exception e){
            return false;
        }

    }

    public void checkTextInElement(String xPath, String text) {
        webDriverWait15.until(ExpectedConditions.textToBePresentInElement(By.xpath(xPath),text));
        try {
            String textFromElement = webDriver.findElement(By.xpath(xPath)).getText();
            Assert.assertThat("Text in element not matched", textFromElement,is(text));
        }catch(Exception e){

            logger.error("Can not work with element " + text);
            Assert.fail("Can not work with element " + text);

        }
    }

    public void selectTextInDDByText(WebElement dropDown, String text) {
        try{
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByVisibleText(text);
            logger.info(text + " was selected in dropdown");

        }catch(Exception e){
            logger.error("Can not work with element DropDown");
            Assert.fail("Can not work with element DropDown");
        }

    }

    public void selectTextInDDByValue(WebElement dropDown, String value){

        try{
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByValue(value);
            logger.info(value + " was selected in dropdown");
        }catch (Exception e){
            logger.error("Can not work with element DropDown");
            Assert.fail("Can not work with element DropDown");
        }

    }

    public void checkCheckBox(WebElement checkbox) {
        try{
            if(!checkbox.isSelected()){
                checkbox.click();
            }
            else{
                logger.info("CheckBox has already selected");
            }


        }catch(Exception e){
            logger.error("Cannot work with element " + checkbox);
            Assert.fail("Cannot work with element " + checkbox);
        }
    }
}
