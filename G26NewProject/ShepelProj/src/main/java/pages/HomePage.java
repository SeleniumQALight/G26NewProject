package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rightAvatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement sparesSubMenu;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(rightAvatar); // проверяем есть ли аватарка (image файл)

    }

    public void clickOnMenuDictionary () {// метод для кликанья на списке "Словари"
        actionsWithOurElements.clickOnElement(menuDictionary);

    }

    public void  clickOnSubMenuSpares () { // метод для клика на меню "Запчасти"
        actionsWithOurElements.clickOnElement(sparesSubMenu);

    }
}
