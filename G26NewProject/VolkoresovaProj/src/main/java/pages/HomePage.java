package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tatyanavolkorezova on 24.07.17.
 */
public class HomePage extends ParentPage {

    @FindBy(xpath=".//img[@class='user-image']")
    private WebElement rightAvatar;

    @FindBy(xpath=".//*[@id='dictionary']/a")
    private WebElement menuDictionary;


    @FindBy(id = "spares")
    private WebElement sparesSubMenu;

    @FindBy(id = "prov_cus")
    private WebElement providersSubMenu;

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

    public void clickOnSubMenuProviders() {
        actionsWithOurElements.clickOnElement(providersSubMenu);
    }

}
