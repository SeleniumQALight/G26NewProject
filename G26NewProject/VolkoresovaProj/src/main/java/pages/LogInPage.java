package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by tatyanavolkorezova on 19.07.17.
 */
public class LogInPage extends ParentPage{

    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLogInPage(){
        open("http://v3.qalight.com.ua/");
    }

    /**
     * Method input login to input
     * @param login
     */
    public void enterLogInToInput(String login) {
        try {
            webDriver.findElement(By.xpath(".//*[@name='_username']")).sendKeys(login);
            logger.info(login+"was inputed into Input Login");

        }catch(Exception e){
            logger.error("Cannot work with input");
            Assert.fail("Cannot work with input");
        }
    }
}
