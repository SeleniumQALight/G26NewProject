package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by andrey.aleksandrov on 19.07.2017.
 */
public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super( webDriver );
    }

    public void openLoginPage() {
        open( "http://v3.qalight.com.ua/" );
    }

    /**
     * Method input login to Login field
     *
     * @param login
     */
    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText( loginInput, login );
    }

    /**
     * Method input password to Password field
     *
     * @param password
     */

    public void enterPasswordToInput(String password) {
        actionsWithOurElements.enterText( passwordInput, password );
    }

    /**
     * Method makes mouse click on submit button
     */
    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement( submitButton );
    }

    public boolean isElementWithTextPresent(String text) {
        return actionsWithOurElements.isElementPresent( ".//*[contains(text(),'" + text + "')]" );
    }

    public void loginUser(String login, String password){
        openLoginPage();
        enterLoginToInput( login );
        enterPasswordToInput( password );
        clickOnSubmitButton();
        ckeckTitle("Учет запчастей");
    }
}
