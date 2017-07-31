package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewSparePage extends ParrentPage {
    // Добавляем FindBy перед конструктором

    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDropDown;

    @FindBy(name = "add")
    private WebElement buttonCreate;
    @FindBy(name = "delete")
    private WebElement buttonDelete;
    //

    public AddNewSparePage(WebDriver webDriver) {
        super(webDriver);
    }

    // метод заполнения инпута
public void enterSpareName (String spareName) {
        // spareNameInput - снизу FindBy
        actionsWithOurElements.enterText(spareNameInput,spareName);
}

// метод который кликает по кнопке создать
    public void clickOnTheButtonCreate(){
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    // метод который кликает на кнопку делете
    public void clickOnTheButtonDelete(){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
// метод который будет работать с дропдаун
    // Мы передаем стрингу которую нужно выбрать
    public void selectElementFromDropDownTypeOfSpare(String nameOfType) {
        // alt+enter - create ,ethod
        // + передать где выбрать этот текст spareTypeDropDown
        actionsWithOurElements.selectTextInDropDownByText(spareTypeDropDown,nameOfType);
    }
}
