package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys(login);
        logger.info(login + " was entered into Input Login");
        }catch(Exception e){
            logger.error("Cannot work with input");
            Assert.fail("Cannot work with input");
        }

        }
    }

