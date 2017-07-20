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
     * Method input login to Login field
     *
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

    /**
     * Method input password to Password field
     *
     * @param password
     */

    public void enterPasswordToInput(String password) {
        try {
            webDriver.findElement( By.xpath( "//input[@id='password']" ) )
                    .sendKeys( password );
            logger.info( password + " was sent to Password input" );
        } catch (Exception e) {
            logger.error( "Can't work with Password input" );
            Assert.fail( "Can't work with Password input" );
        }
    }

    /**
     * Method makes mouse click on submit button
     */
    public void clickButton() {
        try {
            webDriver.findElement( By.xpath( "//button" ) ).click();

            logger.info( "Button was clicked" );
        } catch (Exception e) {
            logger.error( "Can't work with button" );
            Assert.fail( "Can't work with button" );
        }
    }

}
