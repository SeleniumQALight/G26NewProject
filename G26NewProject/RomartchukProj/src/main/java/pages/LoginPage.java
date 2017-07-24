package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPages {
    @FindBy(name = "_username")
    private WebElement loginInput;
    @FindBy(id = "password")
    private WebElement inputPass;
    @FindBy(xpath = ".//button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver){
        super(webDriver);

    }
    public void openLoginPage(){
        open("http://v3.qalight.com.ua/");
    }

    /**
     * method input login to input
     * @param login
     */
    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText(loginInput,login);
//        try{
//            loginInput.sendKeys(login);
//            logger.info(login + "was inputed into Input login");
//        }catch(Exception e){
//            logger.error("Can't work with input");
//            Assert.fail("Can't work with input");
//
//        }
    }
    public void enterPasswToInput(String password){
        actionsWithOurElements.enterText(inputPass, password);

    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    public boolean isElementWithTextPresent(String text) {
        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'" + text + "')]");
    }
}
