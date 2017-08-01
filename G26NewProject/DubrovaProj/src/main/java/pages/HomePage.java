package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rightAvatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement sparesSubMenu;

    @FindBy(id = "prov_cus")
    private WebElement providersSubMenu;

    @FindBy(xpath = ".//*[@href='/logout']")
    private WebElement exitButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(rightAvatar);
        }

        public void clickOnRightAvatar(){
        actionsWithOurElements.clickOnElement(rightAvatar);
        }

        public void clickOnExitButton(){
            actionsWithOurElements.clickOnElement(exitButton);

        }

    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares(){
        actionsWithOurElements.clickOnElement(sparesSubMenu);
    }

    public void clickOnSubMenuProviders(){
        actionsWithOurElements.clickOnElement(providersSubMenu);
    }
}
