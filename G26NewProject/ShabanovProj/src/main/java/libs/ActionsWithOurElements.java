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
 * Created by romas on 20.07.2017.
 * Сюда будем выносить общие действия с нашими элементами
 * enterText - метод очищает и потом добавляет текст в ВебЕлемент
 *
 */
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;


    public ActionsWithOurElements(WebDriver webDriver) { //создаем конструктор. Сюда будем выносить общие действия с нашими элементами
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 15);
    }


    public void enterText(WebElement element, String text) { //этот метод сможет вводить текст в любой елемент
        try {
            element.clear(); //элемент. почисти себя. Почисти поле для ввода
            element.sendKeys(text); //элемент. введи в себя текст который мы передали
            logger.info(text + " was added");

        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }


    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));//юзаем Библиотеку которую передаем как параметр
            //Просим подождать пока элемент будет кликабельный. Там два выбора по локатору и по элементу.
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed(); //обращается к вебдрайверу.Просит найти элемент.И просит присутствует он или нет.
            //тут либо тру либо фолс
        } catch (Exception e) { // если элемента нет - тогда ловит ошибку и возвращает фолс
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch
                (Exception e) {
            return false;
        }
    }

    public void checkTextInElement(String xPath, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.textToBePresentInElement(By.xpath(xPath), text)); // зачеркнут потому что он деприкейтед. Он устарел. Надо дайти новый. Лучше заменить
            String textFromElement = webDriver.findElement(By.xpath(xPath)).getText(); //найди элемент по икспасу и найди текст
            Assert.assertThat("Text in element is not matched", textFromElement, is(text)); //assertThat сравнивает
            //is испортим что-то там КореМатчес
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void selectTextInDDByText(WebElement dropDown,String text) {
        try {
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByVisibleText(text); //selectByVisibleText берет текст который мы ожидаем и сравнивает с тем что мы даем. Посимвольно.
                                                    //Если на проекте много текста то это будет долго по времени
                                                    //selectByValue желательно работать с дропдауном. Загуглить!
            logger.info(text + " was selected in DropDown");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
}