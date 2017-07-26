package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// для работы с нашим классом нам нужен driver, поэтому создаем конструкторЖ
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) { //конструктор, сюда будем выносить всеобщии действия над елементами
        this.webDriver = webDriver;//для этого нам в конструтктор надо передать (WebDriver webDriver) Logger
        logger = Logger.getLogger(getClass()); //нужен чтобы что то нам выводить
    }

    /**
     * Method clears and inputs text to webElement
     *
     * @param element
     * @param text
     */
    public void enterText(WebElement element, String text) {//создали общий метод кот. будет вводить текст в любой input, в параменты передаем (куда ввести, что ввести)
        try {
            element.clear(); //element -почись себя, удали все что в тебе есть
            element.sendKeys(text);//element - введи в себя текст
            logger.info(text + " was inputted"); // инфо что текст введен
        } catch (Exception e) {// надо предусмотреть если что-то пошло не так
            logger.error("Can not work with element " + element);
            Assert.fail("Can not work with element " + element);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element " + element);
            Assert.fail("Can not work with element " + element);
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
        }catch (Exception e) {
            return false;
        }
        }

    }
