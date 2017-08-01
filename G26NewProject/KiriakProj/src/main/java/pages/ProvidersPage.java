package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage{

    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/providers/edit']")
    private WebElement buttonPlus;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonPlus (){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isProviderInList(String nameOfProvider) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfProvider + "']");
    }

}
