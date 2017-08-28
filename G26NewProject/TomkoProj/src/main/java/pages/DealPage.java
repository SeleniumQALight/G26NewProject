package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DealPage extends ParenPage {
    @FindBy(xpath=".//tr[1]/td[2]")
    private WebElement typeFirstRow;

    public DealPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void clickOnTypeFirstRow(){
        actionsWithOurElements.clickOnElement(typeFirstRow);
    }

    public boolean isTypeInList(String nameOfType) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfType + "']");
    }
}
