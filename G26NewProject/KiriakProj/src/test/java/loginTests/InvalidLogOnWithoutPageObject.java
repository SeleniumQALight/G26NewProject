package loginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parrentTest.ParrentTest;


public class InvalidLogOnWithoutPageObject extends ParrentTest{

    public InvalidLogOnWithoutPageObject() {
    }

    @Test
    public void invalidLogIn() {
        webDriver.get("http://v3.qalight.com.ua/");
        webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student1");
        webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("9090");
        webDriver.findElement(By.xpath(".//button[@type='submit']")).click();
        Assert.assertTrue("Assert work", webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed());
    }
}
