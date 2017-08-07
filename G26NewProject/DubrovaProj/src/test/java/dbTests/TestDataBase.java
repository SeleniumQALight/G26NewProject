package dbTests;



import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDataBase extends ParentTest {
    static Logger logger = Logger.getLogger(TestDataBase.class);
    static Database dbMySQL;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        super.setUp();
        dbMySQL = new Database("MySQL_PADB_DB","MySQL");
    }

    @After

    public void tearDown() throws SQLException {
    super.tearDown();
        dbMySQL.quit();

    }

    @Test
    public void testWithDB() throws SQLException {
        logger.info(dbMySQL.selectTable("select login from seleniumTable"));
        logger.info(dbMySQL.selectTable("select * from seleniumTable").get(1));
       // logger.info(dbMySQL.changeDB("INSERT INTO seleniumTable " + "VALUES (19,'dubrovaTest', 'password')"));
        //logger.info(dbMySQL.changeDB("DELETE FROM seleniumTable where login='dubrovaTest'"));
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));
        List check = dbMySQL.selectTable("select * from seleniumTable where login='Student'");
        if (check.size()==1){
            logger.info("Student not found. Will insert it");
            dbMySQL.changeDB("INSERT INTO seleniumTable VALUES (null,'Student', '909090')");
        }
        else {
            logger.info("Student already exists");
        }
        List result = dbMySQL.selectTable("select * from seleniumTable where login='Student'");
        ArrayList userData = (ArrayList) result.get(1);
        String userName = (String) userData.get(2);
        String userPass = (String) userData.get(3);

       loginPage.openLoginPage();
        loginPage.enterLoginToInput(userName);
        loginPage.enterPasswordToInput(userPass);
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not present on Page", homePage.isAvatarPresent(),true);
    }
}
