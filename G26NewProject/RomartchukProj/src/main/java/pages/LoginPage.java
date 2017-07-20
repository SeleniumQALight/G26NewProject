package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPages {
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
        try{
            webDriver.findElement(By.xpath(".//*[@name = '_username']")).sendKeys(login);
            logger.info(login + "was inputed into Input login");
        }catch(Exception e){
            logger.error("Can't work with input");
            Assert.fail("Can't work with input");

        }
    }
}
