package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver)  {
        super(webDriver);
    }

    public void openloginPage(){
        open("http://v3.qalight.com.ua/");
    }

    public void enterLoginToInput(String login) {
        try {
            webDriver.findElement(By.xpath(".//*[@name='_username']"))
                    .sendKeys(login);
            logger.info(login + " was inputed into Onput Login");

        }catch (Exception e) {
            logger.error("Can not work with input");
            Assert.fail("Can not work with input");
        }
    }
}
