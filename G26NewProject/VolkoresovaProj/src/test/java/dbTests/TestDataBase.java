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


public class TestDataBase extends ParentTest {
    static Logger logger = Logger.getLogger(TestDataBase.class);
    static Database dbMySQL;

    public TestDataBase() throws SQLException {
    }

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        super.setUp();
        dbMySQL = new Database("MySQL_PADB_DB", "MySQL");


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
        // logger.info(dbMySQL.resTablechangeDB("INSERT INTO seleniumTable " + "VALUES (777, 'volkorezovaTest', 'pass')"));
        //logger.info(dbMySQL.changeDB("DELETE FROM seleniumTable " + "WHERE login ='Student'"));
        // logger.info(dbMySQL.selectTable("select * from seleniumTable"));

    }


    @Test
    public void workWithDBLogInCredentials() throws SQLException {
        ArrayList dbtable = (ArrayList) dbMySQL.selectTable("select * from seleniumTable where login='Student'");
        if (dbtable.size() == 1) {
            dbMySQL.changeDB("INSERT INTO seleniumTable VALUES (null, 'Student', '909090')");
            logger.info("DB was changed");
        } else {
            logger.info("Student is already exist");
        }

        ArrayList resTable = (ArrayList) dbMySQL.selectTable("select * from seleniumTable where login='Student'");
        String loginToSystem = (String) ((ArrayList) resTable.get(1)).get(2);
        String passwordToSystem = (String) ((ArrayList) resTable.get(1)).get(3);
        logInPage.loginUser(loginToSystem,passwordToSystem);


    }
}

