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

    @FindBy(id= "workers")
    private WebElement workersSubMenu; // 15.08

    @FindBy(xpath = ".//a[@href='/deal']")
    private WebElement menuDeal;

    @FindBy(xpath = ".//a[@href='/statistic']")
    private  WebElement menuStatistic;

    public HomePage(WebDriver webDriver) {

        super(webDriver);
    }

    public boolean isAvatarPresent() {

        return actionsWithOurElements.isElementPresent(rightAvatar);
    }

    public void clickOnMenuDictionary() { //2607,параметры не передаем, метод внутри себя знает что ему делать
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenu(){   // запчасть, 2607, метод открывающий сабменю Запчасть 2607

        actionsWithOurElements.clickOnElement(sparesSubMenu);
    }
    public void clickOnSubMenuWorkers(){
        actionsWithOurElements.clickOnElement(workersSubMenu);
    }
    public void clickOnMenuDeal(){
        actionsWithOurElements.clickOnElement(menuDeal);
    }
    public void clickOnMenuStatistic(){
        actionsWithOurElements.clickOnElement(menuStatistic);
    }
}