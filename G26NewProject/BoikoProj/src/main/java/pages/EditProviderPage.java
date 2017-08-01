package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Оля on 31.07.2017.
 */
public class EditProviderPage extends ParentPage{

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement checkBoxPrivatePerson;

    @FindBy(name = "save")
    private WebElement buttonSave;

    public EditProviderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkTitleH1PresentOnPageWithText(String text){
        actionsWithOurElements.checkTextInElement(".//H1", text);
    }

    public void makeProviderAsPrivatePerson() {
        actionsWithOurElements.clickCheckBox(checkBoxPrivatePerson);
    }

    public void clickOnButtonSave() {
        actionsWithOurElements.clickOnElement(buttonSave);
    }
}
