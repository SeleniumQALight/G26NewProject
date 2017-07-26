package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Создаем метод
// потом создаем конструктор
public class HomePage extends ParrentPage {

    @FindBy(xpath = ".//img[@class='user-image']")
    WebElement rightAvatar;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresent() {
        // ctrl + isElementPresent и смотрим что передаем - сверху прописуем локатор
        // потом на имени метод rightAvatar - новый метожд
        //потом дописуем return с переди метода
        return actionsWithOurElements.isElementPresent(rightAvatar);

    }
}
