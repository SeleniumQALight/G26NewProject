package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yuliya_Rodionova on 7/27/2017.
 */
public class SparePage extends ParentPage {
    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/spares/edit']")
    private WebElement buttonPlus;

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonPlus(){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean IsSpareInList(String nameOfSpare) {
        return actionsWithOurElements
                .isElementPresent(".//*[text()='" + nameOfSpare + "']");
    }
}
