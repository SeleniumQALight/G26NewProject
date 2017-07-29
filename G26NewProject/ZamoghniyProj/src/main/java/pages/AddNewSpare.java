package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Asus on 27.07.2017.
 */
public class AddNewSpare extends ParentPages {
    public AddNewSpare(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDropDown;

    @FindBy(name = "add")
    private WebElement buttonCreate;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public void enterSpareName(String spareName){
        actionsWithOurElements.enterText(spareNameInput, spareName);
    }
    public void clickOnCreateButton (){
        actionsWithOurElements.clickOnElement(buttonCreate);
    }
    public  void clickOnDeleteButton () {
        actionsWithOurElements.clickOnElement(buttonDelete);

    }

    public void selectElementFromDDTypeOfSpare(String nameOfSpareType){
        actionsWithOurElements.selectTextInDDbyText(spareTypeDropDown, nameOfSpareType);
    }
}
