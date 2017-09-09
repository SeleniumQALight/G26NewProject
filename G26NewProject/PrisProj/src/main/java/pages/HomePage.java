package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmitriy on 24.07.2017.
 */

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rightAvatar;

    @FindBy(xpath = ".//*[@class='fa fa-book']")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement spareSubMenu;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean isAvatarPresent() {
        return actionWithOurElements.isElementPresent(rightAvatar);
    }

    public void clickOnMenuDictionary() {

        actionWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {

        actionWithOurElements.clickOnElement(spareSubMenu);
    }
}