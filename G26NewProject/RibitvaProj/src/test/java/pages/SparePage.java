package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alex on 26.07.2017.
 */
public class SparePage extends ParentPage{
    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/spares/edit']")

    private WebElement buttonPlus;

    public SparePage(WebDriver webDriver) {super(webDriver);}

    public void clickOnButtonPlus(){
        actionsWithOurElement.clickOnElement(buttonPlus);
    }

    public boolean isSpareInList(String nameOfSpare) {
        return actionsWithOurElement.
                isElementPresent(".//*[text()='" + nameOfSpare + "']");
    }
}
