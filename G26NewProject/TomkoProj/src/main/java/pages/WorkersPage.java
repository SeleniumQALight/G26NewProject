package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkersPage extends ParenPage {
   @FindBy(xpath = ".//tr[1]/td[1]")
   private WebElement firstCell; //first row on the page workers

    public WorkersPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void clickOnFirstCell(){
        actionsWithOurElements.clickOnElement(firstCell);
    }

    public boolean isNewWorkerNameEdited(String newNameWoker) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + newNameWoker + "']");
    }
}


