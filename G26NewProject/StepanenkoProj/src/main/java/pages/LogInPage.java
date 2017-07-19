package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 19.07.2017.
 */
public class LogInPage extends ParentPage{
    public LogInPage(WebDriver webDriver) {
        //super - это обращение к parent
        super(webDriver);
    }

    public void openLoginPage(){
        open("http://v3.qalight.com.ua/");

    }

    /**
     * method login into 'Login' prompt
     * @param login
     */
    public void enterLoginToInput(String login) {
        try{
            webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys(login);
            logger.info(login + " was accepted as a valid login");
        }
        catch (Exception e){
            logger.error("Cannot accept login input");
            Assert.fail("Cannot accept login input");

        }
    }
}
