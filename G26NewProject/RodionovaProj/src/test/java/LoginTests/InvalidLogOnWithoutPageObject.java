package LoginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

/**
 * Unit test for simple App.
 */
public class InvalidLogOnWithoutPageObject extends ParentTest{

    public InvalidLogOnWithoutPageObject() {
    }

    @Test
    public void invalidLogOn(){
        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//*[@name='_username']"))
                .sendKeys("Student");
        webDriver.findElement(By.xpath(".//*[@id='password']"))
                .sendKeys("0000");
        webDriver.findElement(By.xpath(".//button")).click();
        Assert.assertTrue("Assert works!",webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());

    }


}
