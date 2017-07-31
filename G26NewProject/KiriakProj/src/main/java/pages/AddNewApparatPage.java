package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewApparatPage extends ParentPage{

    @FindBy(id = "apparat_apparatNumber")
    private WebElement apparatNumberInput;

    @FindBy(id = "apparat_apparatComment")
    private WebElement apparatCommentInput;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public AddNewApparatPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickButtonCreate(){
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void enterApparatNumber (String apparatNumber){
        actionsWithOurElements.enterText(apparatNumberInput,"111");
    }

    public void enterApparatComment (String apparatComment){
        actionsWithOurElements.enterText(apparatCommentInput,"Термостат");
    }

    public void clickButtonDelete(){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

}
