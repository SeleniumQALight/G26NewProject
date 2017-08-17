package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddNewSparePage extends ParenPage { //2707
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
        actionsWithOurElements.enterText(spareNameInput,spareName); // в параметрах (куда внести , что внести)
    }


    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }
    public void clickButtonDelete(){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void selectElementFromDDSpareType(String nameOfType){ //drop-down (DD), в скобках,то что нам надо выбрать
    actionsWithOurElements.selectTextInDDByText(spareTypeDropDown,nameOfType); // тут впервые создали метод selectTextInDDByText, передаем в метод nameOfType, который прийдет в тесте
                                                            // Alt+enter создаем метод selectTextInDDByText, буден создан вклассе АctionsWithOurElements
    }
}

