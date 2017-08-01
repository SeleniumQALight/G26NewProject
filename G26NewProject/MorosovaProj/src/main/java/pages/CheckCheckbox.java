package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckCheckbox extends ParentPage
{

    @FindBy (id = "prov_cus_proCustIsFl")
    private WebElement checkBoxPrivatePerson;

    @FindBy (id = "prov_cus_isOurFirm")
    private WebElement checkBoxIsOurFirm;

    @FindBy (id = "prov_cus_proCustName")
    private WebElement custNameInput;

    @FindBy (id = "prov_cus_proCustAddress")
    private WebElement custAdressInput;

    @FindBy (id = "prov_cus_proCustPhone")
    private WebElement custPhoneInput;

    @FindBy (name = "add")
    private WebElement buttonCreate;

    public CheckCheckbox(WebDriver webDriver)
    {
        super(webDriver);
    }

    public void checkChekbox ()
    {

    }
}
