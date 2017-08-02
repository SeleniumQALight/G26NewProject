package dbTests;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Оля on 02.08.2017.
 */
public class TestDB {
    static Logger logger = Logger.getLogger(TestDB.class); //Name of class for logger
    static Database dbMySQL; //We can create method just by name

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_PADB_DB","MySQL");
    }

    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
    }

    @Test
    public void testWithDB() throws SQLException {
        logger.info(dbMySQL.selectTable("select login from seleniumTable"));
        logger.info(dbMySQL.selectTable("select * from seleniumTable").get(1));
       // logger.info(dbMySQL.changeDB("Insert into seleniumTable " + "Values(77,'boikoTest','pass')"));
        logger.info(dbMySQL.changeDB("delete from seleniumTable where login='boikoTest'"));
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));

    }
}
