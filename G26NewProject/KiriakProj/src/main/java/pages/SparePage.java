package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparePage extends ParentPage{

    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/spares/edit']")
    private WebElement buttonPlus;


    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonPlus (){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isSpareInList(String nameOfSpare) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfSpare + "']");
    }
}
