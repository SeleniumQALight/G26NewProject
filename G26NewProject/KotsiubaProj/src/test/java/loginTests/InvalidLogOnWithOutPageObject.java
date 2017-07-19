package loginTests;

import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.By;

import parrentTest.ParrentTest;

/**
 * Created by Нов on 17.07.2017.
 */
public class InvalidLogOnWithOutPageObject extends ParrentTest {

    public InvalidLogOnWithOutPageObject() {

    }

    @Test
    public void invalidLogOn() {
        webDriver.get("http://v3.qalight.com.ua/login");
        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student");
        webDriver.findElement(By.xpath(".//input[@id='password']")).sendKeys("2222");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        Assert.assertTrue(webDriver.findElement(By.xpath(".//*[text()='Учет запчастей']")).isDisplayed());
    }


}
