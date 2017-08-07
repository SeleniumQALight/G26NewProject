package dbTests;

import libs.Database;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.ParentPage;
import parentTest.ParentTest;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Оля on 02.08.2017.
 */
public class TestDB{

    public WebDriver webDriver;
    static Logger logger = Logger.getLogger(TestDB.class); //Name of class for logger
    static Database dbMySQL; //We can create method just by name

    public LoginPage loginPage;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_PADB_DB","MySQL");
        File file = new File("");
        File fileFF = new File(".././drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // create objects of the pages
        loginPage = new LoginPage(webDriver);
    }

    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
        if (!(webDriver==null)) {  // Close web driver only if web driver exists
           webDriver.quit();
        }
    }

    @Test
    public void testWithDB() throws SQLException {
       // logger.info(dbMySQL.selectTable("select login from seleniumTable"));
       // logger.info(dbMySQL.selectTable("select * from seleniumTable").get(1));
       // logger.info(dbMySQL.changeDB("Insert into seleniumTable " + "Values(77,'boikoTest','pass')"));
        logger.info(dbMySQL.changeDB("delete from seleniumTable where login='Student'"));
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));
        if ((dbMySQL.selectTable("select * from seleniumTable where login = 'Student'").size()) == 1)
            dbMySQL.changeDB("Insert into seleniumTable " + "Values(77,'Student','909090')");
        List<ArrayList> LoginValues;
        List<ArrayList> PasswordValues;
        LoginValues = dbMySQL.selectTable("select login from seleniumTable where login='Student'");
        PasswordValues = dbMySQL.selectTable("select passWord from seleniumTable where login='Student'");

        loginPage.loginUser(LoginValues.get(1).get(1).toString(),PasswordValues.get(1).get(1).toString());
    }
}
