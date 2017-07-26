package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(xpath = ".//button")
    private WebElement buttonSubmit;

    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        open("http://v3.qalight.com.ua/");
    }

    /**
     * Method input login to input
     * @param login
     */
    public void enterLoginToInput(String login) {
//        try{
//            loginInput.sendKeys(login);
//            logger.info(login + " was inputed into Input Login");
//        }catch (Exception e){
//            logger.error("Can not work with input");
//            Assert.fail("Can not work with input");
//        }
       actionsWithOurElements.enterText(loginInput, login);
    }
    public void enterpassWordToInput(String passWord){
        actionsWithOurElements.enterText(inputPass, passWord);
    }

    public void clickOnSubmitButtton() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    public Boolean isElementWithTextPresent(String text) {
        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'"+text+"')]");
    }
}
