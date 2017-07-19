package loginTests;

import org.junit.Assert;
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
        webDriver.get( "http://v3.qalight.com.ua/" );
        webDriver.findElement( By.xpath( "//input[@name='_username']" ) )
                .sendKeys( "student" );
        webDriver.findElement( By.xpath( "//input[@id='password']" ) )
                .sendKeys( "wrongPassword" );
        webDriver.findElement( By.xpath( "//button" ) ).click();
        Assert.assertTrue( webDriver.findElement( By.xpath( "//*[contains(text(),'Учет запчастей')]" ) ).isDisplayed() );
    }
    
}

