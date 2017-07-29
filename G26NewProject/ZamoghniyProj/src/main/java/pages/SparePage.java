package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparePage extends ParentPages{
    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/spares/edit']")
    WebElement buttonPlus;
    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }
    public  void  clickOnButtonPlus(){
        actionsWithOurElements.clickOnElement(buttonPlus);

    }

    public boolean isSpareInList(String spareName) {
        return  actionsWithOurElements.
                isElementPresent(".//*[text()='"+spareName+"']");
    }
}
