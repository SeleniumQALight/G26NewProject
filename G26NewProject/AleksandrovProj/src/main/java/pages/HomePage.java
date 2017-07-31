package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    public HomePage(WebDriver webDriver) {
        super( webDriver );
    }

    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rightAvatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    WebElement menuDictionary;

    @FindBy(id = "spares")
    WebElement sparesSubMenu;

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent( rightAvatar );
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement( menuDictionary );
    }

    public void ClickOnSubMenuSpares() {
        actionsWithOurElements.clickOnElement( sparesSubMenu );
    }
}
