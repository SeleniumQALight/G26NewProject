package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by 1 on 15.08.2017.
 */
public class AddNewWorkerPage extends ParenPage{
    @FindBy(id="workers_workerSurname")
    private WebElement workerSurnameInput;

    @FindBy(id="workers_workerName")
    private WebElement workerNameInput; //where to input

    @FindBy(id="workers_workerMiddleName")
    private WebElement workerMiddleNameInput; //where to input

    @FindBy(name="save")
    private WebElement buttonSave;

    public AddNewWorkerPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void enterWorkerSurname(String workerSurname) {
        actionsWithOurElements.enterText(workerSurnameInput, workerSurname);
    }
    public void enterWorkerName(String workerName){
        actionsWithOurElements.enterText(workerNameInput,workerName); // в параметрах (куда внести , что внести)
    }
    public void enterWorkerMiddleName(String workerMiddleName){
        actionsWithOurElements.enterText(workerMiddleNameInput,workerMiddleName);
    }
    public void clickOnButtonSave(){
        actionsWithOurElements.clickOnElement(buttonSave);

    }

}
