package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Asus on 19.07.2017.
 */
public class LoginPage extends ParentPages{


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
        try{
            webDriver.findElement(By.xpath(".//*[@name='_username']"))
                    .sendKeys(login);
            logger.info(login + " was inputed into Input Login");

        }catch(Exception e){
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");

        }
    }

    public void enterPasswordToInput(String password) {
        try{
            webDriver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
            logger.info(password + "was inputed into Input Password");
        }catch(Exception e){
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");

        }
    }
}
