package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alex on 27.07.2017.
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

    public void enterSpareName(String spareName){
        actionsWithOurElement.enterText(spareNameInput, spareName);
    }

    public void clickButtonCreat(){
        actionsWithOurElement.clickOnElement(buttonCreate);
    }

    public void selectElementFromDDSpareType(String nameOfType){
        actionsWithOurElement.selectTextInDDByText(spareTypeDropDown, nameOfType);
    }
}
