package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement loginInput;
    @FindBy(id = "password")
    private WebElement inputPass;
    @FindBy(xpath = ".//button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super( webDriver );
    }

    public void openLoginPage() {
        open( "http://v3.qalight.com.ua/" );
    }

    /**
     * Method input login to Login input
     * @param login
     */
    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText(loginInput,login);


    }
    public void enterPasswordIntoElement(String password){
actionsWithOurElements.enterText(inputPass, password);

    }

    public void clickOnSubmitButton() {
        //alt+enter- sozdat metod field
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    public boolean isElementWithTextPresent(String text) {
        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'"+text+"')]");
    }
}
