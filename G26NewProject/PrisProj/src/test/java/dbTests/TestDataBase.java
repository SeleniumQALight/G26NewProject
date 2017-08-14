package dbTests;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Dmitriy on 02.08.2017.
 */
public class TestDataBase {

    static Logger logger = Logger.getLogger(TestDataBase.class); //Написали TestDataBase.class чтобы знали где он находится

    //Создаем обьект статичесткий для работы с ним
    static Database dbMySQL;
    @Before
    //Добавили описание Exception они могут здесь быть
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        //Создали обьект с переменной и он будет подключен к базе данных по таких параметрах URl и Драйвер
    dbMySQL = new Database("MySQL_PADB_DB", "MySQL");
    }

    @After
    public void tearDown() throws SQLException { //Закрываем коннект к базе данных
        dbMySQL.quit();

    }
    @Test
    //Он подключиться к базе данных выполнит select и выведет в консоль
    public void testWithDB() throws SQLException {
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));
        logger.info(dbMySQL.selectTable("select login from seleniumTable").get(1));
        //Добавили в базу свои данные
        //logger.info((dbMySQL.changeDB("Insert into seleniumTable " + "values (13, 'dimaTest', 'pass')")));

        //Удаляем свои данныех которые мы заменили
        logger.info((dbMySQL.changeDB("delete from seleniumTable where login='dimaTest'")));
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));
    }
}
