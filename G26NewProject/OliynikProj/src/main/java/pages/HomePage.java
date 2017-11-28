package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rigthAvatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement sparesSubMenu;

    public HomePage(WebDriver webDriver) {

        super(webDriver);
    }

    public boolean isAvatarPresent() {
      return
              actionsWithOurElements.isElementPresent(rigthAvatar);
    }

public void clickOnMenuDictionary(){
        actionsWithOurElements.clickElementActionsWithElements(menuDictionary);
        logger.info("click on DD dictionary in HomePage");
}
public void clickOnSubMenuSpares(){
    actionsWithOurElements.clickElementActionsWithElements(sparesSubMenu);
    logger.info("Click on Submenu in HomePage");
}
    }


