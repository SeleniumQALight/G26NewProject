package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Kleine-Hexe on 23.07.2017.
 */
public class MainPage extends ParentPage {

    @FindBy(xpath = ".//a[@class='dropdown-toggle']")
    public WebElement avatar;

    @FindBy(xpath = ".//ul[@class='dropdown-menu']")
    private WebElement profilePopUp;

    @FindBy(xpath = ".//ul[@class='dropdown-menu']//a[@href='/logout']")
    private WebElement logoutButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAvatar(){
      webDriver.findElement(By.xpath(".//img[@class='user-image']")).click();
    }

    public boolean isProfilePopUpPresent(){
        return actionsWithOurElements.isElementPresent(".//ul[@class='dropdown-menu']");
    }

    public void clickOnLogoutButton(){
        webDriver.findElement(By.xpath(".//ul[@class='dropdown-menu']//a[@href='/logout']")).click();
    }
}