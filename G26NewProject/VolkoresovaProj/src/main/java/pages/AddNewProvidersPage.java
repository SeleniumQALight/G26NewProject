package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tatyanavolkorezova on 29.07.17.
 */
public class AddNewProvidersPage extends ParentPage {


    @FindBy(id= "prov_cus_proCustName")
    private WebElement provNameField;

    @FindBy(id= "prov_cus_proCustAddress")
    private WebElement provAddressField;

    @FindBy(id= "prov_cus_proCustPhone")
    private WebElement provPhoneField;

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement checkboxPrivatePerson;

    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement checkboxIsOurFirm;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    public AddNewProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void enterProviderName(String providerName){
        actionsWithOurElements.enterText(provNameField, providerName);
    }

    public void enterProviderAddres(String providerAddress){
        actionsWithOurElements.enterText(provAddressField, providerAddress);
    }

    public void enterProviderPhone(String providerPhone){
        actionsWithOurElements.enterText(provPhoneField, providerPhone);
    }

    public void clickButtonCreate(){
        actionsWithOurElements.clickOnElement(buttonCreate);
    }


    public void checkCheckBoxPrivatePerson() {
        actionsWithOurElements.checkCheckBox(checkboxPrivatePerson);

    }

    public void checkCheckBoxIsOurFirm() {
        actionsWithOurElements.checkCheckBox(checkboxIsOurFirm);

    }
}
