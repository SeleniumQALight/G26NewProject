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
dbMySql = new Database("MySQL_PADB_DB","MySQL");
    }
    @Test
    public void testWithDb() throws SQLException {
        logger.info(dbMySql.selectTable("select login from seleniumTable" ));
        logger.info(dbMySql.selectTable("select * from seleniumTable").get(1));
        logger.info(dbMySql.changeDb("INSERT INTO seleniumTable " + "VALUES (45, 'Zamozhnyi','pass')"));
        logger.info(dbMySql.selectTable("select * from seleniumTable" ));
    }
    @After
    public void tearDown() throws SQLException {
dbMySql.quit();
    }
}
