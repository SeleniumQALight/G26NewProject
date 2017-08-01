package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewDealPage extends ParentPage{

    @FindBy(id = "deal_dealType")
    private WebElement dealTypeDropDown;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    @FindBy(id = "deal_customer")
    private WebElement customerDropDown;

    @FindBy(id = "deal_provider")
    private WebElement providerDropDown;

    @FindBy(id = "deal_dealDate_date_year")
    private WebElement yearDropDown;

    @FindBy(id = "deal_dealDate_date_month")
    private WebElement monthDropDown;

    @FindBy(id = "deal_dealDate_date_day")
    private WebElement dayDropDown;

    @FindBy(id = "deal_dealDate_time_hour")
    private WebElement hourDropDown;

    @FindBy(id = "deal_dealDate_time_minute")
    private WebElement minuteDropDown;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public AddNewDealPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickButtonCreate(){
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectYearInDDByValue(String year){
        actionsWithOurElements.selectValueInDDByValue(yearDropDown,year);
    }

    public void selectMonthInDDByValue(String month){
        actionsWithOurElements.selectValueInDDByValue(monthDropDown,month);
    }

    public void selectDayInDDByValue(String day){
        actionsWithOurElements.selectValueInDDByValue(dayDropDown,day);
    }

    public void selectHourInDDByValue(String hour){
        actionsWithOurElements.selectValueInDDByValue(hourDropDown,hour);
    }

    public void selectMinuteInDDByValue(String minute){
        actionsWithOurElements.selectValueInDDByValue(minuteDropDown,minute);
    }

    public void selectTypeInDDByValue(String nameOfType){
        actionsWithOurElements.selectValueInDDByValue(dealTypeDropDown,nameOfType);
    }

    public void selectCustomerInDDByValue(String nameOfCustomer){
        actionsWithOurElements.selectValueInDDByValue(customerDropDown,nameOfCustomer);
    }

    public void selectProviderInDDByValue(String nameOfProvider){
        actionsWithOurElements.selectValueInDDByValue(providerDropDown,nameOfProvider);
    }

    public void clickButtonDelete(){
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
