package libs;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    // Конструктор нужен для того, чтобы елемент webDriver, который прийдет из других классов, был сдесь обработан
    // Тоже с логером
    WebDriver webDriver; // добавляем сюда тот же драйвер, который работает в других классах
    Logger logger;
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger= Logger.getLogger(getClass()); // Добавляем логер
    }

    /**
     * Method clears and inputs text to webElement
     * @param element
     * @param text
     */
    // Создаем метот, который будет вводить текст в любой элемент и чиститься
    public void enterText(WebElement element, String text) {
        try{
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted");
        }catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }

    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("element was clicked");

        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    public boolean isElementWithTextPresent(String locatorWithText) {
        try {
            webDriver.findElement(By.xpath(locatorWithText));
        }catch (Exeptions e){
            returns false;
        }

        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'" + text + "')]");// Локатор универсальный на поиск любого текста на любой пейдже
    }
}

