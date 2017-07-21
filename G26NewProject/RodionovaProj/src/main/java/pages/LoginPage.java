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
    private WebElement inputPassword;

    @FindBy(xpath = ".//button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        open("http://v3.qalight.com.ua/");
    }

    /**
     * Method login to input
     * @param login
     */
    public void enterLoginToInput(String login) {
           actionsWithOurElements.enterText(loginInput,login);
     /*   try {
            loginInput.sendKeys(login);
            logger.info(login + "was inputed into Input Login");
        } catch (Exception e){
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }*/
    }

    public void enterPasswordToInput(String password){
        actionsWithOurElements.enterText(inputPassword,password);

    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    public boolean isElementWithTextPresent(String text) {

        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'"+text+"')]");

    }
}
