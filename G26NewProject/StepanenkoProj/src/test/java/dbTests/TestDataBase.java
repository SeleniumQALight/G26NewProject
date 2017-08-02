package dbTests;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by admin on 02.08.2017.
 */
public class TestDataBase {
    static Logger logger = Logger.getLogger(TestDataBase.class);
    static Database dbMySQL;

    @Before
    public void  setUp () throws SQLException, IOException, ClassNotFoundException {
        //("MySQL_PADB_DB", "MySQL") это все берем из config.properties
        //прописываем подключение к ДБ: ключ к url to DB; ключ к драйверу)
        dbMySQL = new Database("MySQL_PADB_DB", "MySQL");

    }
    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
    }

    @Test
    // тест: подключиться к БД, достанет все из таблицы и выведет все в консоль. Обработает эксепшен.
    // Эксепшен добавили через alt+enter
    public void testWithDB () throws SQLException {
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));
        // получить первую строку значений
        logger.info(dbMySQL.selectTable("select * from seleniumTable").get(1));
        //logger.info(dbMySQL.changeBD("insert into seleniumTable " + " values (33, 'stepanenko', 'pass')"));
        logger.info(dbMySQL.changeBD("delete from seleniumTable where login='stepanenko'"));
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));
    }
}
