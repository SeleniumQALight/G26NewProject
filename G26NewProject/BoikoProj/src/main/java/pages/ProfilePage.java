package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Оля on 01.08.2017.
 */
public class ProfilePage extends ParentPage {

    @FindBy(id = "userProfileEdit_user_name")
    private WebElement userName;

    @FindBy(xpath = ".//button[@type='submit' and @name='save']")
    private WebElement buttonSave;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterUserName(String text) {
        actionsWithOurElements.enterText(userName, text);
    }

    public void clickOnSaveButton(){
        actionsWithOurElements.clickOnElement(buttonSave);
    }

    public void checkTitleH3WithUserName(String text){
        actionsWithOurElements.checkTextInElement(".//H3", "Профиль пользователя "+ text);
    }
}
