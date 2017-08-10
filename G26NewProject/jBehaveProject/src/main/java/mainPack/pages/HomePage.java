package mainPack.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    @FindBy(xpath = ".//img[@class='user-image']")
    private WebElement rightAvatar;

    public boolean isAvatarPresent(){
        try {
            return rightAvatar.isDisplayed();
        }catch (Exception e){
            System.out.println("isAvatarPresent");
            return false;
        }
    }
}
