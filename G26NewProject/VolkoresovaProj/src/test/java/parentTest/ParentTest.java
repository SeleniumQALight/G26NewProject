package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by tatyanavolkorezova on 17.07.17.
 */
public class ParentTest {
    public WebDriver webDriver;

    public ParentTest() {

    }

    @Before
    public void setUp(){
        File fileFF = new File("./macDrivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        //open browser
        webDriver= new ChromeDriver();
        //maximize window
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }


}
