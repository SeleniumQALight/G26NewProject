package dBTests;


import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class TestDataBase
{
    static  Logger logger = Logger.getLogger (TestDataBase.class);
    static Database dbMySQL;
    @Before
    public void setUp()
            throws SQLException, IOException, ClassNotFoundException
    {
        dbMySQL = new Database("MySQL_PADB_DB", "MySQL");
    }


    @After
    public void tearDown()
            throws SQLException
    {
        dbMySQL.quit();
    }

    @Test
    public void testWithDB ()
            throws SQLException
    {
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));
        logger.info(dbMySQL.selectTable("select * from seleniumTable").get(1));
        logger.info(dbMySQL.chengeDB("DELETE FROM seleniumTable WHERE " + "login = 'MorozovaTest'"));
//        logger.info(dbMySQL.chengeDB("INSERT INTO seleniumTable " + "VALUES (22, 'MorozovaTest', 'pass')"));
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));
    }
}
