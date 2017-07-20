package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by andrey.aleksandrov on 19.07.2017.
 */
public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super( webDriver );
    }

    public void openLoginPage() {
        open( "http://v3.qalight.com.ua/" );
    }

    /**
     * Method input login to Login input
     * @param login
     */
    public void enterLoginToInput(String login) {
        try {

            webDriver.findElement( By.xpath( "//input[@name='_username']" ) )
                    .sendKeys( login );
            logger.info( login + " was sent to Login input" );
        } catch (Exception e) {
            logger.error( "Can't work with login input" );
            Assert.fail( "Can't work with login input" );
        }
    }
}
