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
    public WebElement Avatar;

    @FindBy(xpath = ".//ul[@class='dropdown-menu']")
    private WebElement ProfilePopUp;

    @FindBy(xpath = ".//ul[@class='dropdown-menu']//a[@href='/logout']")
    private WebElement LogoutButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAvatar(){
      webDriver.findElement(By.xpath(".//ul[@class='dropdown-menu']")).click();
    }

    public boolean isProfilePopUpPresent(){
        return actionsWithOurElements.isElementPresent(".//ul[@class='dropdown-menu']");
    }

    public void clickOnLogoutButton(){
        webDriver.findElement(By.xpath(".//ul[@class='dropdown-menu']//a[@href='/logout']")).click();
    }
}