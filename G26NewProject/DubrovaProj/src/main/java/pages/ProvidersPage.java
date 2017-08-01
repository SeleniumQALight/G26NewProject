package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Kleine-Hexe on 29.07.2017.
 */
public class ProvidersPage extends ParentPage{
    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/providers/edit']")
    private WebElement buttonAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void clickOnButtonAdd(){
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isProviderInList(String providersName) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + providersName + "']");
    }
}
