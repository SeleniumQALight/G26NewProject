package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParenPage {
    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rightAvatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a") //2607
    private WebElement menuDictionary;  //2607

    @FindBy(id = "spares")
    private WebElement sparesSubMenu; // запчасть, 2607

    //@FindBy(id= "workers")

    public HomePage(WebDriver webDriver) {

        super(webDriver);
    }

    public boolean isAvatarPresent() {

        return actionsWithOurElements.isElementPresent(rightAvatar);
    }

    public void clickOnMenuDictionary() { //2607,параметры не передаем, метод внутри себя знает что ему делать
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenu() { //метод открывающий сабменю Запчасть 2607

        actionsWithOurElements.clickOnElement(sparesSubMenu);
    }
}