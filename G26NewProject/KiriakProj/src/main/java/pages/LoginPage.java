package pages;

import org.apache.log4j.Logger;
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
        super(webDriver);
    }

    public void openLoginPage() {
        open("http://v3.qalight.com.ua/");
    }

    /**
     * Method input login
     *
     * @param login
     */
    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText(loginInput, login);

        //  actionsWithOurElements.clickElement();
        //        try {
        //            loginInput.sendKeys(login);
        //            logger.info(login + " was inputed into Input Login");
        //        } catch (Exception e){
        //            logger.error("Can not work with input");
        //            Assert.fail("Can not work with input");
        //        }
    }

    /**
     * Method input password
     * @param passWord
     */
    public void enterPasswordToInput(String passWord) {
        actionsWithOurElements.enterText(inputPass, passWord);
    }

    /**
     * Method click on button
     */
    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    /**
     * Method element with test present
     * @param text
     * @return
     */
    public boolean isElementWithTestPresent(String text) {
        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'" + text + "')]");
    }

    /**
     * Method login user
     * @param login
     * @param password
     */
    public void loginUser(String login, String password) {
        openLoginPage();
        enterLoginToInput(login);
        enterPasswordToInput(password);
        clickOnSubmitButton();
        checkTitle("Учет запчастей");
    }
}
