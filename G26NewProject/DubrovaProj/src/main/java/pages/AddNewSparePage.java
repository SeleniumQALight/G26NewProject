package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Kleine-Hexe on 27.07.2017.
 */
public class AddNewSparePage extends ParentPage {

    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDropDown;

    @FindBy(name = "add")
    private WebElement buttonCreate;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public AddNewSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterText(spareNameInput, spareName);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void selectElementFromDDSpareType(String nameOfType) {
        actionsWithOurElements.selectTextInDDByText(spareTypeDropDown, nameOfType);
    }

    public void selectElementFromDDSpareTypeByValue(String nameOfValue) {
        actionsWithOurElements.selectOptionInDDByValue(spareTypeDropDown, nameOfValue);
    }
}