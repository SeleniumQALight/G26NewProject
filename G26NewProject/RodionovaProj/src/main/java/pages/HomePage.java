package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Yuliya_Rodionova on 7/24/2017.
 */
public class HomePage extends ParentPage{
    @FindBy(xpath = ".//img=[@class='user-image']")
    WebElement correctAvatar;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresnt() {
        return actionsWithOurElements.isElementPresent(correctAvatar);
    }
}
