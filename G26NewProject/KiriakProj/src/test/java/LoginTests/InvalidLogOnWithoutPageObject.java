package LoginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parrentTest.ParrentTest;


public class InvalidLogOnWithoutPageObject extends ParrentTest{

    public InvalidLogOnWithoutPageObject() {
    }

    @Test
    public void invalidLogOn() {
        loginPage.openLoginPage();
        loginPage.enterLoginToInput("Student");
        loginPage.enterPasswordToInput("5676");
        loginPage.clickOnSubmitButton();

        //webDriver.get("http://v3.qalight.com.ua/");
        //webDriver.findElement(By.xpath(".//input[@name='_username']")).sendKeys("Student1");

        //webDriver.findElement(By.xpath(".//input[@name='_password']")).sendKeys("9090");
        //webDriver.findElement(By.xpath(".//button[@type='submit']")).click();

        checkAC("Text 'Учет запчастей' not found",loginPage.isElementWithTestPresent("Учет запчастей"),true);

        //checkAC("Text 'Учет запчастей' not found",webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed(),true);

        //Assert.assertTrue("Assert work", webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed());
    }
}

