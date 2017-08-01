package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 */

public class SparePage extends ParentPage { //создаем конструктор через альт + Ентер
                                            //конструктор надо для того чтоб эта страница работала с браузером который она естендит
                                            //а не создала свой

    @FindBy (xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/spares/edit']")
    private WebElement buttonPlus;


    public SparePage(WebDriver webDriver) {
        super(webDriver);
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public void clickOnButtonPlus(){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isSpareInList(String nameOfSpare) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfSpare + "']");//локатор в который вставится нахвание
    }
}
