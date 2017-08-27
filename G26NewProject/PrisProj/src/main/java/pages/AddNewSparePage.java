package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmitriy on 27.07.2017.
 */
public class AddNewSparePage extends ParentPage { //Создали страницу SparePage

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


    public void enterSpareName(String spareName) {//метод которий передаст елемент и текст куда ввести
        actionWithOurElements.enterText(spareNameInput, spareName);
    }

    public void clickButtonCreate() {
        actionWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickButtonDelete() {
        actionWithOurElements.clickOnElement(buttonDelete);
    }

    public void selectElementDropDownSpareType(String nameOfType) {
        actionWithOurElements.selectTextInDropDownByText(spareTypeDropDown, nameOfType);
    }

    public void select1ElementDropDownSpareType(String valueOfType) {
        actionWithOurElements.selectValueInDropDownByValue(spareTypeDropDown, valueOfType);
    }
}
