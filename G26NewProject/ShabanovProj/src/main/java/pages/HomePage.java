package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{ //надо создать конструктор
    @FindBy(xpath = ".//img[@class='img-circle']")
    WebElement rightAvatar;

    public HomePage(WebDriver webDriver) {
        super(webDriver);



    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(rightAvatar);
    }
}
