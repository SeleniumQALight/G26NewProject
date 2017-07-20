package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Asus on 19.07.2017.
 */
public class LoginPage extends ParentPages{

    @FindBy(name = "_username")
    private WebElement loginInput;
    @FindBy (id="password")
    private WebElement passInput;
    @FindBy (xpath = ".//button")
    private  WebElement buttonSubmit;



    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void openLoginPage(){
        open("http://v3.qalight.com.ua");

    }

    /**
     * Method input login to Input.
     * @param login
     */
    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText(loginInput,login);
       // try{
         //   loginInput.sendKeys(login);
           // webDriver.findElement(By.xpath(".//*[@name='_username']")) -теперь находится в веб обьекте loginInput
                  //  .sendKeys(login);
           // logger.info(login + " was inputed into Input Login");

       //}catch(Exception e){
        //    logger.error("Can not work with input");
          //  Assert.fail("Can not work with input");

       // }
    }

    public void enterPasswordToInput(String password) {
       actionsWithOurElements.enterText(passInput, password);
        //try{
         //   webDriver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
        //    logger.info(password + "was inputed into Input Password");
        //}catch(Exception e){
         //   logger.error("Can not work with input");
          //  Assert.fail("Can not work with input");

       // }
    }
    public void clickOnSubmitButton(){
        actionsWithOurElements.clickOnElement(buttonSubmit);
       // try{
        //   actionsWithOurElements.clickOnButton;
        //    logger.info("button was clicked ");
       // }catch(Exception e){
       //     logger.info("button can not clicked");
      //      Assert.fail("button can not clicked");
       // }
    }

    public boolean isElementWithTextPresent(String text) {

        return actionsWithOurElements.isElementPresent(".//*[contains](text(),'"+text+"')");
    }
}
