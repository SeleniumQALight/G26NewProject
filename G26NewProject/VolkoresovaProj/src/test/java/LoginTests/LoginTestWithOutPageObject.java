package LoginTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by tatyanavolkorezova on 13.07.17
 */
public class LoginTestWithOutPageObject {
    private WebDriver webDriver;



    @Test
    public void validLogOn(){

        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        //open browser
        webDriver= new ChromeDriver();
        //maximize window
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://v3.qalight.com.ua/");
        System.out.println("Page was opened");
        //close vkladka, broweser is still opened
        //quit - close broweser
        webDriver.quit();
    }
}
