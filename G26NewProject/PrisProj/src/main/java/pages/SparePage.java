package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmitriy on 26.07.2017.
 */
public class SparePage extends ParentPage{ //Создали страницу Запчастей и он наследуется от Парентпейдж

    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/spares/edit']")
    private WebElement buttonPlus;

    public SparePage(WebDriver webDriver) {//Пробрасываем webDriver
        super(webDriver);
    }

    public void clickOnButtonPlus () {
        actionWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isSpareInList(String nameOfSpare) {
        return actionWithOurElements.isElementPresent(".//*[text()='" + nameOfSpare + "']");
    }
}
