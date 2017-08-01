package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProviderPage extends ParentPage
{
    @FindBy (xpath = ".//*[@href = 'http://v3.test.itpmgroup.com/dictionary/deal_type/edit']")
    private WebElement buttonAdd;

    public ProviderPage (WebDriver webDriver)
    {
        super (webDriver);
    }

    public void clickOnButtonPlus ()
    {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isNewProvidersInList (String nameOfProvider)
    {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfProvider + "']");
    }

}
