package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Kleine-Hexe on 29.07.2017.
 */
public class AddNewProviderPage extends ParentPage {

    @FindBy(id = "prov_cus_proCustIsFl")
   private WebElement checkboxPrivatePerson;

    @FindBy(id= "prov_cus_proCustName")
    private WebElement providersNameField;

    @FindBy(id= "prov_cus_proCustAddress")
    private WebElement providersAddressField;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    public AddNewProviderPage(WebDriver webDriver) {
        super(webDriver);
    }
public void enterProvidersName(String providersName){
        actionsWithOurElements.enterText(providersNameField, providersName);
  }

  public void enterProvidersAddress(String providersAddress){
    actionsWithOurElements.enterText(providersAddressField, providersAddress);
  }

  public void checkingCheckboxPP(){
      actionsWithOurElements.checkCheckbox(checkboxPrivatePerson);
  }

    public void clickButtonCreate() {
      actionsWithOurElements.clickOnElement(buttonCreate);
    }
}
