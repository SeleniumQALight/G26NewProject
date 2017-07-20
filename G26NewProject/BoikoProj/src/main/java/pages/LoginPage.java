package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Оля on 19.07.2017.
 */
public class LoginPage extends ParentPage{

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
        try{
            webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys(login);
            logger.info(login + " was inputed into Input Login");
        }catch (Exception e){
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }

    }

    public void enterPasswordToInput(String password) {
        try{
            webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys(password);
            logger.info(password + " was inputed into Password Login");
        }catch (Exception e){
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }

    public void pressButtonSubmit() {
        try{
            webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
            logger.info("Button was clicked");
        }catch (Exception e){
            logger.error("Can not work with button");
            Assert.fail("Can not work with button");
        }
    }
}

