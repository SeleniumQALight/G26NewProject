package dbTests;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestDataBase {
    static Logger logger = Logger.getLogger(TestDataBase.class);
    static Database dbMySQL;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_PADB_DB", "MySQL");
    }

    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
    }

    @Test
    public void testWithDB() throws SQLException {
//        logger.info(dbMySQL.selectTable("Select * From seleniumTable"));
//        logger.info(dbMySQL.selectTable("Select * From seleniumTable").get(1));
//        logger.info(dbMySQL.changeDB("Insert into seleniumTable " + "values (80, 'kompantsev', 'qqq111')"));
//        logger.info(dbMySQL.selectTable("Select * From seleniumTable"));
        logger.info(dbMySQL.changeDB("Delete From seleniumTable where passWord='qqq111'"));
        logger.info(dbMySQL.selectTable("Select * From seleniumTable"));
    }
}
