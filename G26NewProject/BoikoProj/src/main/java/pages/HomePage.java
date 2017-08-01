package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Оля on 24.07.2017.
 */
public class HomePage extends ParentPage{

    @FindBy (xpath = ".//img[@class='user-image']")
    private WebElement rightAvatar;

    @FindBy (xpath = ".//*[@id='dictionary']/a")   //click on link Dictionary
    private WebElement menuDictionary;

    @FindBy (id = "spares")
    private WebElement sparesSubMenu;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(rightAvatar);
    }

    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);

    }

    public void clickOnSubMenuSpares(){
        actionsWithOurElements.clickOnElement(sparesSubMenu);
    }
}
