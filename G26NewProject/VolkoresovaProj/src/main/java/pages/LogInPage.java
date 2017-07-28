package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by tatyanavolkorezova on 19.07.17.
 */
public class LogInPage extends ParentPage{

    @FindBy(name = "_username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(xpath = ".//button")
    private WebElement buttonSubmit;

    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLogInPage(){
        open("http://v3.qalight.com.ua/");
    }

    /**
     * Method input login to input
     * @param login
     */
    public void enterLogInToInput(String login) {
        actionsWithOurElements.enterText(loginInput,login);
//        try {
//            loginInput.sendKeys(login);
//            logger.info(login+"was inputed into Input Login");
//
//        }catch(Exception e){
//            logger.error("Cannot work with input");
//            Assert.fail("Cannot work with input");
//        }
    }


    public  void enterPassWordToInput(String passWord){
        actionsWithOurElements.enterText(inputPass, passWord);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit);

    }

    public boolean isElementWithTextPresent(String text) {

        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'"+text+"')]");
    }

    public void loginUser(String login, String password) {
        openLogInPage();
        enterLogInToInput(login);
        enterPassWordToInput(password);
        clickOnSubmitButton();
        checkTitle("Учет запчастей");

    }
}
