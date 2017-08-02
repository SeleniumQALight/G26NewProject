package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tatyanavolkorezova on 29.07.17.
 */
public class ProvidersPage extends ParentPage {
    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/providers/edit']")
    private WebElement buttAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonAdd() {
        actionsWithOurElements.clickOnElement(buttAdd);
    }


    public boolean isProviderInList(String nameOfProvider) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfProvider + "']");
    }



}
