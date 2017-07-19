package LoginTest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;


public class InvalidLogOnWithoutPadeobject extends ParentTest{

    public InvalidLogOnWithoutPadeobject(){ }

    @Test
    public void invalidLogOn() {

        loginPage.openloginPage();
 //       webDriver.get("http://v3.qalight.com.ua/"); 18 строка будет заменена 17 строкой
        loginPage.enterLoginToInput("Student");
//        webDriver.findElement(By.xpath(".//*[@name='_username']"))
//                .sendKeys("Student");
        webDriver.findElement(By.xpath(".//*[@id='password']"))
                .sendKeys("2222");
        webDriver.findElement(By.xpath(".//button")).click();
        checkAC("Text 'Учет запчастей' not found",
                webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']"))
                        .isDisplayed(), true );
//        Assert.assertTrue(webDriver.findElement(By.xpath(".//b[text()='Учет запчастей']")).isDisplayed());
    }

}

