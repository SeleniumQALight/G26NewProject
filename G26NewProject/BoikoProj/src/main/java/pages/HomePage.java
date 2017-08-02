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

    @FindBy (id = "prov_cus")
    private WebElement providersSubMenu;

    @FindBy (xpath = ".//span[@class='hidden-xs']")
    private WebElement rightLoginName;

    @FindBy (xpath = ".//div[@class='pull-left info']//p")
    private WebElement leftLoginName;

    @FindBy (xpath = ".//a[@href='/logout']")
    private WebElement buttonLogout;

    @FindBy (xpath = ".//a[@href='/users/profile/16']")
    private WebElement buttonProfile;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(rightAvatar);
    }

    public boolean isRightUserNameTextCorrect(String text) {
        return actionsWithOurElements.getTextFromElement(".//span[@class='hidden-xs']").equalsIgnoreCase(text);
    }

    public boolean isLeftUserNameTextCorrect(String text) {
        return actionsWithOurElements.getTextFromElement(".//div[@class='pull-left info']//p").equalsIgnoreCase(text);
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

    public void clickOnRightLoginName(){
        actionsWithOurElements.clickOnElement(rightLoginName);
    }

    public void clickOnLogoutButton(){
        actionsWithOurElements.clickOnElement(buttonLogout);
    }

    public void clickOnProfileButton(){
        actionsWithOurElements.clickOnElement(buttonProfile);
    }
}
