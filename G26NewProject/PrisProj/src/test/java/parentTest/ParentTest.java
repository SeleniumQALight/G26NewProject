package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 17.07.2017.
 */
public class ParentTest {
   public WebDriver webDriver; //Обьявили модификатором public чтобы был доступен в обоих package(инкапсуляция)

    //Конструктор передает во внутрь класса, настроить обьект. передаем обьект с одного класса в другом//работай с обьектом этого класса
    public ParentTest() {
    }

    @Before
    public void setUp() {
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() {
        webDriver.quit();
    }
}
