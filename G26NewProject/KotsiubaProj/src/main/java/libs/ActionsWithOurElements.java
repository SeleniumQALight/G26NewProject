package libs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;

public class ActionsWithOurElements {
    // создаем конструкто, что б в обьект передать параметр
    WebDriver webDriver;
    Logger logger;

    // инициализируем обьект
    WebDriverWait webDriverWait15;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());

        // создаем новый обьект, каждые пол секунды он будет счелкать по кнопке
        webDriverWait15 = new WebDriverWait(webDriver, 15);
    }

    /**
     * Method clean and inputs to webElement
     *
     * @param element
     * @param text
     */
    // метод который будет вводить текст в любой инпут
    public void enterText(WebElement element, String text) {
        // предусмотреть внештатную ситуацию
        try {
            // тут мы непосредственно работаем с елементом
            element.clear();
            // введи в себя текс
            element.sendKeys(text);
            logger.info(text + "was inputted");
        } catch (Exception e) {
            logger.error("Cannot work with Element" + element);
            Assert.fail("Cannot work with Element" + element);
        }
    }

    // elment - потому что везде елементы будут использоваться
    public void clickOnElement(WebElement element) {
        try {
            // прописуем что жди елемент пока и прописуем жди пока елемент не станет кликабельным и передаем ЕЛМЕНТ(по вебдрайверу)
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Clicked on element");
        } catch (Exception e) {
            logger.error("Cannot work with Element" + element);
            Assert.fail("Cannot work with Element" + element);
        }

    }

    // метод который ищет текст
    // два return потому что мы либо возвращаем тру либо фолс
    // isElementPresent -
    public boolean isElementPresent(String locatorWithText) {
        try {
            return webDriver.findElement(By.xpath(locatorWithText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
// меняем на element
    // void -> boolean

    // мы спрашиваем может ли найти на странице аватарку, если да то возвращает, если нет - то фолс
    public boolean isElementPresent(WebElement element) {
        try {
            // Должен вернуть елмент
            return element.isDisplayed();

        } catch (Exception e) {
            return false;
        }

    }

    public void checkTextInElement(String xPath, String text) {
        try {
            // будем дожидаться появление елемента h1
            // зачеркнутый метод это имееться ввиду что он рабочий но есть еще новей
            webDriverWait15.until(ExpectedConditions.textToBePresentInElement(By.xpath(xPath),text));
            String textFromElement = webDriver.findElement(By.xpath(xPath)).getText();
            Assert.assertThat("Text in Element not matched", textFromElement,
                    is(text));
        } catch (Exception e) {
            logger.error("Cannot work with Element" );
            Assert.fail("Cannot work with Element" );
        }
    }


    // nameOfType - text
    // передать в этот метод в каком елементе что выбрать
    public void selectTextInDropDownByText(WebElement dropDown, String text) {
        try {
            // нужно отталкиваться от мануального тесткейса!!! для работы с дроп дауном
            // DropDown - это селект
            // мы получаем все что находиться внутри дропдауна
                      Select optionsFromDropDown = new Select(dropDown);
            // select by value - работает быстрей в разы!!
                        optionsFromDropDown.selectByVisibleText(text);
            logger.info(text + " was selected in dropDown");
        } catch (Exception e) {
            logger.error("Cannot work with DropDown" );
            Assert.fail("Cannot work with DropDown" );
        }
    }
}
