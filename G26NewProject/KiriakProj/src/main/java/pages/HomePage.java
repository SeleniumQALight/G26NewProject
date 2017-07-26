package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rightAvatar;

    @FindBy(xpath=".//a[@href='http://v3.qalight.com.ua/']")
    WebElement urlElement;

    public HomePage(WebDriver webDriver){
        super(webDriver);
    }


    public boolean isAvatarPresent(){
        return actionsWithOurElements.isElementPresent(rightAvatar);
    }

//    public void isTitlePresent(WebElement element){
//        actionsWithOurElements.getTitle(urlElement);
//    }

}

