package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Asus on 24.07.2017.
 */
public class HomePage extends ParentPages {
    @FindBy (xpath = ".//img[@class='user-image']")
    private WebElement rightAvatar;

    @FindBy (xpath = ".//*[@id='dictionary']/a")
    private WebElement dictionaryMenu;

    @FindBy (id="spares")
    private  WebElement sparesSubMenu;

    public HomePage(WebDriver webDriver) {super(webDriver);}

    public boolean isAvatarPresent(){
        return  actionsWithOurElements.isElementPresent(rightAvatar);

    }


    public void clickOnDictionaryMenu(){
        actionsWithOurElements.clickOnElement( dictionaryMenu);
    }
    public void clickOnSparesSubMenu(){
        actionsWithOurElements.clickOnElement( sparesSubMenu );
    }
}
