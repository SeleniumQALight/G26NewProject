package loginTests;

import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Created by andrey.aleksandrov on 17.07.2017.
 */
public class InvalidLogOnWithoutPageObject extends ParentTest {

    public InvalidLogOnWithoutPageObject() {

    }

    @Test
    public void invalidLogOn() {
        logInPage.openLoginPage();
//        webDriver.get( "http://v3.qalight.com.ua/" );
        logInPage.enterLoginToInput("student");
//        webDriver.findElement( By.xpath( "//input[@name='_username']" ) )
//                .sendKeys( "student" );
//        webDriver.findElement( By.xpath( "//input[@id='password']" ) )
//                .sendKeys( "wrongPassword" );
//        webDriver.findElement( By.xpath( "//button" ) ).click();
//        Assert.assertTrue( webDriver.findElement( By.xpath( "//*[contains(text(),'Учет запчастей')]" ) ).isDisplayed() );
        checkAcceptanceCriteria( "Text 'Учет запчастей' not found", webDriver.findElement( By.xpath( "//*[contains(text(),'Учет запчастей')]" ) ).isDisplayed() , true);

    }

}

