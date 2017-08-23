package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Created by Dmitriy on 24.07.2017.
 */

public class HomePage extends ParentPage{
    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rightAvatar;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


    public boolean isAvatarPresent() {
        return actionWithOurElements.isElementPresent(rightAvatar);
    }
}