package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class AddNewDealPage extends ParenPage {
    @FindBy(id = "deal_dealType")
    private WebElement dealTypeDD;

    @FindBy(name="save")
    private WebElement buttonSave;

    public AddNewDealPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectTypeInDDByValue(String nameOfType) {
        actionsWithOurElements.selectValueInDDByValue(dealTypeDD, nameOfType);
    }
    public void clickButtonSave(){
        actionsWithOurElements.clickOnElement(buttonSave);
    }
}