package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApparatPage extends ParentPage{

    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/apparat/edit']")
    private WebElement buttonPlus;

    public ApparatPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnButtonPlus (){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isElementWithTestPresent(String text) {
        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'" + text + "')]");
    }

}
