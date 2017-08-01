package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Создаем метод
// потом создаем конструктор
public class HomePage extends ParrentPage {

    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rightAvatar;

    // Он создался ( найти словари )
    // прописуем к нему ХПасс
    @FindBy (xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    // теперь Хпасс на запчасти
    @FindBy(id = "spares")
    // обьявляем переменную
    private WebElement sparesSubMenu;




    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresent() {
        // ctrl + isElementPresent и смотрим что передаем - сверху прописуем локатор
        // потом на имени метод rightAvatar - новый метожд
        //потом дописуем return с переди метода
        return actionsWithOurElements.isElementPresent(rightAvatar);

    }

    // метод который кликает по кнопке словари
    // () параметр мы не передаем, так как метож внутри себя выполняет
    // alt+enter -> create field
    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    // метод клика на запчасти
    public void clickOnSubMenuSpares(){
        actionsWithOurElements.clickOnElement(sparesSubMenu);
    }
}
