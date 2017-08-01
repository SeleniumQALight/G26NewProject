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

    // это конструктор класса, прописываем драйвер и логер, что и везде, чтобы с ним работать
    // конструктор передает что-то с чем работать, параметры метода.
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 15);
    }

    /**
     * Method Clears and inputs text into webElement (login prompt)
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
            logger.info(text + " was input");
        } catch (Exception e) {
            logger.error("Cannot work with element" + element);
            Assert.fail("Cannot work with element" + element);
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
        try {
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void checkTextInElement(String xPath, String text) {
        try {
            webDriverWait15.until(
                    ExpectedConditions
                            .textToBePresentInElement(By.xpath(xPath),text));
            String textFromElement = webDriver.findElement(By.xpath(xPath))
                    .getText();
            Assert.assertThat("Text in element not matched",
                    textFromElement,
                    is(text));
        }catch (Exception e){
            logger.error("Can not work with element " );
            Assert.fail("Can not work with element " );
        }
    }

    public void selectTextInDDByText(WebElement dropDown, String text) {
        try {
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByVisibleText(text);
            logger.info(text + " was selected in DropDown");
        }catch (Exception e){
            logger.error("Can not work with DropDown " );
            Assert.fail("Can not work with DropDown " );
        }
    }
}

