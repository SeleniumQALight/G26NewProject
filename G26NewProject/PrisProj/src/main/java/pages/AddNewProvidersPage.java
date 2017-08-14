package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmitriy on 13.08.2017.
 */
public class AddNewProvidersPage extends ParentPage {

    @FindBy(id = "prov_cus_proCustName")
    private WebElement procustname;

    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement procustaddress;

    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement procustphone;

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement checkboxNamePrivatePerson;

    @FindBy(id = "prov_cus_isOurFirm")
    private WebElement checkboxNameIsOurFirm;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    @FindBy(name = "save")
    private WebElement buttonSave;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public AddNewProvidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterProvidersName(String ProCustName) {//метод которий передаст елемент и текст куда ввести
        actionWithOurElements.enterText(procustname, ProCustName);
    }

    public void enterProvidersNameAddress(String ProCustAddress) {//метод которий передаст елемент и текст куда ввести
        actionWithOurElements.enterText(procustaddress, ProCustAddress);
    }

    public void enterProvidersNamePhone(String ProCustPhone) {//метод которий передаст елемент и текст куда ввести
        actionWithOurElements.enterText(procustphone, ProCustPhone);
    }

    public void clickCheckboxPrivatePerson() {
        actionWithOurElements.clickCheckBox(checkboxNamePrivatePerson);
    }

    public void clickCheckboxIsOurFirm() {
        actionWithOurElements.clickCheckBox(checkboxNameIsOurFirm);
    }

    public void makeProviderAsPrivatePerson() {
        actionWithOurElements.clickCheckBox(checkboxNamePrivatePerson);
    }

    public void clickProvidersButtonCreate() {
        actionWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickProvidersButtonSave() {
        actionWithOurElements.clickOnElement(buttonSave);
    }

    public void clickButtonDelete() {
        actionWithOurElements.clickOnElement(buttonDelete);
    }
}
