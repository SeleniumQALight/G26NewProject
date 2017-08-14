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
 * Created by Dmitriy on 20.07.2017.
 */
//Мы туда выносим общие действие над елементами страницы
public class ActionWithOurElements { //В этот класс мы будем выносить все елементы страницы

    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 15); //Драйвер жди 15 секунд каждые пол секунды он будет счелкать по кнопке
    }

    /**
     * Method clears and inputs text to webElement
     *
     * @param element
     * @param text
     */
    //Этот метод будет передавать елемент и текст который мы будем вводить
    public void enterText(WebElement element, String text) {
        try {
            element.clear(); //Почисти поле
            element.sendKeys(text); //Введи текст
            logger.info(text + " was inputted");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    /**
     * Method Click element Button
     *
     * @param element
     */
    //потому что везде елементы будут использоваться
    public void clickOnElement(WebElement element) {
        try {
            //прописуем что жди елемент пока и прописуем жди пока елемент не станет кликабельным и передаем ЕЛМЕНТ(по вебдрайверу)
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }

    }

    public void clickOnElement(String locator) {
        try {
            WebElement element = webDriver.findElement(By.xpath(locator));
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element ");
        }
    }

    /**
     * Method is element with locator
     *
     * @param locatorWithText
     * @return
     */
    //два return потому что мы либо возвращаем тру либо фолс
    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method is isElementPresent
     *
     * @param element
     * @return
     */
    // мы спрашиваем может ли найти на странице аватарку, если да то возвращает, если нет - то фолс
    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method is checkTextInElement
     *
     * @param xPath
     * @param text
     */
    public void checkTextInElement(String xPath, String text) {

        try {
            // будем дожидаться появление елемента h1
            // зачеркнутый метод это имееться ввиду что он рабочий но есть еще новей
            webDriverWait15.until(ExpectedConditions.textToBePresentInElement(By.xpath(xPath), text));//Дожидаемся появления елемента h1
            String textFromElement = webDriver.findElement(By.xpath(xPath)).getText();
            Assert.assertThat("Text in element not mathed", textFromElement, is(text)); //Сравнивает фактич из ожидаемым
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    // передать в этот метод в каком елементе что выбрать
    public void selectTextInDropDownByText(WebElement dropDown, String text) {
        try {
            //Библиотека умеет работать с ДропДауном и с него получаем все елементы
            // нужно отталкиваться от мануального тесткейса!!! для работы с дроп дауном
            // DropDown - это селект
            // мы получаем все что находиться внутри дропдауна
            Select optionsFromDropDown = new Select(dropDown);
            // Выбери нам из текста
            optionsFromDropDown.selectByVisibleText(text);
            //optionsFromDropDown.selectByValue(text);
            logger.info(text + " was selected si DropDown by Text");
        } catch (Exception e) {
            logger.error("Can not work with DropDown");
            Assert.fail("Can not work with DropDown");
        }
    }

    //Метод выбора значения в DropDown по value
    public void selectValueInDropDownByValue(WebElement dropDown, String text) {
        try {
            //Библиотека умеет работать с ДропДауном и с него получаем все елементы
            Select optionsFromDropDown = new Select(dropDown);
            // Выбери нам из value
            // select by value - работает быстрей в разы!!
            optionsFromDropDown.selectByValue(text);
            logger.info(text + "was selected si DropDown by value");
        } catch (Exception e) {
            logger.error("Can not work with DropDown");
            Assert.fail("Can not work with DropDown");
        }
    }

    //Метод по работе с checkbox(сначала у него узнать состояние , и в зависимости от состояния - кликнуть по нему или нет)
    public void clickCheckBox(WebElement checkBox) {
        try {
            Boolean statusCheckBox = checkBox.isSelected();
            if (statusCheckBox) {
                logger.info("check box is initially checked");
            } else {
                webDriverWait15.until(ExpectedConditions.elementToBeClickable(checkBox));
                checkBox.click();
                logger.info("check box was clicked");
            }
        } catch (Exception e) {
            logger.error("Can not work with element " + checkBox);
            Assert.fail("Can not work with element " + checkBox);
        }
    }
}