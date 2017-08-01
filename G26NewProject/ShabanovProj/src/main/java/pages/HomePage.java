package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{ //надо создать конструктор
    @FindBy(xpath = ".//img[@class='img-circle']")
    WebElement rightAvatar;

    @FindBy (xpath = ".//*[@id='dictionary']/a") //нашли все айдишки дикшинари а в них все ссылки по тегу а
    private WebElement menuDictionary;

    @FindBy (id = "spares") //найди айди спарсе (запчасти на англ)
    private WebElement sparesSubMenu;

    public HomePage(WebDriver webDriver) {
        super(webDriver);



    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(rightAvatar);
    }

    public void clickOnMenuDictionary (){

        actionsWithOurElements.clickOnElement(menuDictionary); //альт ентр на менюдикшинари. Криейт филд.
                                                                // Создается вверху под ФайндБай приватный метод.
                                                                //Выше создаем ФайндБай
    }

    public void clickOnSubMenuSpares (){
        actionsWithOurElements.clickOnElement(sparesSubMenu);

    }

}