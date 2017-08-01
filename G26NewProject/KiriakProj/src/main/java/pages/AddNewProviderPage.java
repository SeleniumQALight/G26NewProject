package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewProviderPage extends ParentPage{

    @FindBy(id = "prov_cus_proCustName")
    private WebElement proCustNameInput;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement proCustAddressInput;

    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement proCustPhoneInput;

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement privatePersonCheckBox;

    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement isOurFirmCheckbox;

    @FindBy(name = "delete")
    private WebElement buttonDelete;


    public AddNewProviderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickButtonCreate(){
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void enterProCustName (String proCustName){
        actionsWithOurElements.enterText(proCustNameInput,"Provider1");
    }
    public void enterProCustAddress (String proCustAddress){
        actionsWithOurElements.enterText(proCustAddressInput,"Ukraine");
    }
    public void enterProCustPhone (String proCustPhone){
        actionsWithOurElements.enterText(proCustPhoneInput,"044-456-54-86");
    }

    public void selectCheckBoxPrivatePerson (){
        actionsWithOurElements.getCheckboxState(privatePersonCheckBox);
        actionsWithOurElements.setCheckboxState(privatePersonCheckBox,"checked");
    }

    public void selectCheckBoxIsOurFirm (){
        actionsWithOurElements.getCheckboxState(isOurFirmCheckbox);
        actionsWithOurElements.setCheckboxState(isOurFirmCheckbox,"checked");
    }
}
