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


// для работы с нашим классом нам нужен driver, поэтому создаем конструкторЖ
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15; //объявили переменную ожидания 15с, инициализируем ее в конструкторе

    public ActionsWithOurElements(WebDriver webDriver) { //конструктор, сюда будем выносить всеобщии действия над елементами
        this.webDriver = webDriver;//для этого нам в конструтктор надо передать (WebDriver webDriver) Logger
        logger = Logger.getLogger(getClass()); //нужен чтобы что то нам выводить
        webDriverWait15 = new WebDriverWait(webDriver, 15);//инициализируем в конструкторе переменную ожидания 15с
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
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
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
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void checkTextInElement(String xpath, String text) {
        try {
            webDriverWait15.until(ExpectedConditions
                    .textToBePresentInElement(By.xpath(xpath), text));//эти методы берем на сайте seleniumhg.github.io
            String textFromElement = webDriver.findElement(By.xpath(xpath)).getText();
            Assert.assertThat("Text in element not matched", textFromElement,
                    is(text));
        } catch (Exception e) {// надо предусмотреть если что-то пошло не так
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element ");
        }
    }

    public void selectTextInDDByText(WebElement dropDown, String text) { //DD-DropDown, при создании меняем предложенный nameOfType на text,т.к.
        // будем сами выбирать текст v DD; передаем в параметры (в каком элементе, что выбрать);
        try {
            Select optionsFromDD = new Select(dropDown); //Select (это dropDown)  - это библиотека селениум;
            // optionsFromDD -наш объект; этой строкой получили все что находится в дроп-дауне, все его опции.
            optionsFromDD.selectByVisibleText(text); // тут работаем с созданным объектом optionsFromDD, можем содавать
            // команды или просить что-то выполнить, (text) тут передаем текст text
            // selectByVisibleText как работает метод: берет ожидаемый текст и сравнивает по-очередно с каждым тестом из дропдауна, сравнивает посимвольно
            // если нет привязки к тексту то лучше работать ч/з value(это м-д selectByValue), он сокращает время подборки нужного текста
            logger.info(text + " was selected in DropDown"); // чтобы понимать был ли выбран текст
        } catch (Exception e) {
            logger.error("Can not work with element ");
            Assert.fail("Can not work with element ");
        }
    }

    public void selectValueInDDByValue(WebElement dropDown, String value) {
        try{
            Select optionsFromDD = new Select(dropDown);
            optionsFromDD.selectByValue(value);
            logger.info(value + " was selected in DropDown");
        } catch (Exception e){
            logger.error("Can not work with value in DropDown");
            Assert.fail("Can not work with value in DropDown");
        }
    }

    public boolean getCheckBoxState (WebElement checkBox) {
        if(checkBox.isSelected()){
            logger.info("Element is selected");
            return true;
        }
        else {
            logger.info("Element isn't selected");
            return false;
        }

    }

}

