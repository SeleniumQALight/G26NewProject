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
    static Database dbMySql;
    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB", "MySQL");

    }
    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }

    @Test
    public void testWithDB() throws SQLException {
        logger.info(dbMySql.selectTable("SELECT * FROM seleniumTable"));
        logger.info(dbMySql.selectTable("SELECT * FROM seleniumTable").get(1));
        //logger.info(dbMySql.changeDB("Insert into seleniumTable value (9, 'Kotsiuba', 'password')"));
        //logger.info(dbMySql.selectTable("SELECT * FROM seleniumTable"));
        logger.info(dbMySql.changeDB("Delete from seleniumTable where login='Kotsiuba'"));
        logger.info(dbMySql.selectTable("SELECT * FROM seleniumTable"));
    }

}
