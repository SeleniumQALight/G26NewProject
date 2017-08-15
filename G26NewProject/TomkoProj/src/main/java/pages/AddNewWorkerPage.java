package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by 1 on 15.08.2017.
 */
public class AddNewWorkerPage extends ParenPage{
    @FindBy(id="workers_workerName")
    private WebElement workerNameInput;

    @FindBy(name="save")
    private WebElement buttonSave;

    public AddNewWorkerPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void enterWorkerName(String workerName){
        actionsWithOurElements.enterText(workerNameInput,workerName); // в параметрах (куда внести , что внести)
    }
    public void clickOnButtonSave(){
        actionsWithOurElements.clickOnElement(buttonSave);

    }

}
