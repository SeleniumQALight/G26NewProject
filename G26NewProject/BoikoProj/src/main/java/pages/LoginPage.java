package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Оля on 19.07.2017.
 */
public class LoginPage extends ParentPage{

    @FindBy(xpath = ".//input[@name='_username']")
    private WebElement loginInput; //создает объект

    @FindBy(name = "_password")
    private WebElement inputPass;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
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
        actionsWithOurElements.enterText(loginInput, login);

//        try{
//            loginInput.sendKeys(login);
//            logger.info(login + " was inputed into Input Login");
//        }catch (Exception e){
//            logger.error("Can not work with input");
//            Assert.fail("Can not work with input");
//        }

    }

    public void enterPasswordToInput(String password) {
        actionsWithOurElements.enterText(inputPass, password);
//        try{
//            webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys(password);
//            logger.info(password + " was inputed into Password Login");
//        }catch (Exception e){
//            logger.error("Can not work with input");
//            Assert.fail("Can not work with input");
//        }
//    }
    }
    public void pressButtonSubmit() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
//        try{
//            webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
//            logger.info("Button was clicked");
//        }catch (Exception e){
//            logger.error("Can not work with button");
//            Assert.fail("Can not work with button");
//        }
    }

    public boolean isElementWithTextPresent(String text) {
        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'"+text+"')]");
    }

    public boolean isFieldLoginInitiallyEmpty() {
        return actionsWithOurElements.isFieldEmpty(loginInput);
    }

    public boolean isFieldPasswordInitiallyEmpty() {
        return actionsWithOurElements.isFieldEmpty(inputPass);
    }

    public void loginUser(String login, String password) {
        openLoginPage();
        enterLoginToInput(login);
        enterPasswordToInput(password);
        pressButtonSubmit();
        checkTitle("Учет запчастей");
    }


}

