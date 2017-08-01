package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rightAvatar;

    @FindBy(xpath=".//a[@href='http://v3.qalight.com.ua/']")
    WebElement urlElement;

    @FindBy(xpath=".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement sparesSubMenu;

    @FindBy(xpath=".//*[@id='deal']/a")
    private WebElement menuDeal;

    @FindBy(xpath=".//*[@id='apparat']/a")
    private WebElement apparatSubMenu;

    @FindBy(xpath = ".//*[@id='prov_cus']/a")
    private WebElement providersSubMenu;

    public HomePage(WebDriver webDriver){
        super(webDriver);
    }


    public boolean isAvatarPresent(){
        return actionsWithOurElements.isElementPresent(rightAvatar);
    }

    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares(){
        actionsWithOurElements.clickOnElement(sparesSubMenu);
    }

    public void clickOnMenuDeal(){
        actionsWithOurElements.clickOnElement(menuDeal);
    }

    public void clickOnSubMenuApparat(){
        actionsWithOurElements.clickOnElement(apparatSubMenu);
    }

    public void clickOnSubMenuProviders(){
        actionsWithOurElements.clickOnElement(providersSubMenu);
    }
}

