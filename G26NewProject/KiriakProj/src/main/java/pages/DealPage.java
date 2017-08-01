package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealPage extends ParentPage{

    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/deal/edit']")
    private WebElement buttonPlus;


    public DealPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonPlus (){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isDealInList(String nameOfDeal) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfDeal + "']");
    }

}
