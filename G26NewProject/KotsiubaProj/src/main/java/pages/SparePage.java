package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// extends ParrentPage и создаем конструктор
//
public class SparePage extends ParrentPage {

    //нажимаем на кнопку +
    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/spares/edit']")
    private WebElement buttonPlus;
    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    // метод клик он +
    public void clickOnTheButtonPlus(){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isSpareInList(String nameOfSpare) {
        // ".//*[@text='" + spare1 + " ' ")  - локатора в тело которого вставиться наш текст
              return actionsWithOurElements.isElementPresent(".//*[@text='" + nameOfSpare + " ' ");
    }
}
