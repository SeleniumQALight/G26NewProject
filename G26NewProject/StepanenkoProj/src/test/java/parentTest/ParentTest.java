package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LogInPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

/**
 * Created by admin on 17.07.2017.
 */
public class ParentTest {
   public WebDriver webDriver;
   public LogInPage logInPage;

    public ParentTest() {

    }

    //если условия в before не выполнились , то дальше тест не идет
    @Before
    public void setUp() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        //команда открыть браузер
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logInPage=new LogInPage(webDriver);
    }

    @After
    public void tearDown() {
        //закрыть браузер
        webDriver.quit();}
        public void checkAcceptanceCriteria(String message, boolean actualResult, boolean expectedResult){
        //assertThat делает сравнение AR vs ER
            Assert.assertThat(message, actualResult, is (expectedResult));
    }
    }

