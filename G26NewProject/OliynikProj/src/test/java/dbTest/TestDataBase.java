package dbTest;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by User on 02.08.2017.
 */
public class TestDataBase {
    static Logger logger = Logger.getLogger(TestDataBase.class);
    static Database dbMySQL;
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

    logger.info(dbMySQL.selectTable("SELECT login FROM seleniumTable"));
    logger.info(dbMySQL.selectTable("SELECT * FROM seleniumTable").get(1));
   //logger.info(dbMySQL.changeDB("INSERT INTO seleniumTable " + "VALUES (27, 'oliynikTest','pass')"));
logger.info("SELECT * FROM seleniumTable");
    logger.info(dbMySQL.selectTable("SELECT * FROM seleniumTable"));
}
}
