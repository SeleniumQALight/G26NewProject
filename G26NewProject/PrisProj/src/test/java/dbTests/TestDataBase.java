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

/**
 * Created by Dmitriy on 02.08.2017.
 */
public class TestDataBase extends ParentTest {

    static Logger logger = Logger.getLogger(TestDataBase.class); //Написали TestDataBase.class чтобы знали где он находится

    //Создаем обьект статичесткий для работы с ним
    static Database dbMySQL;

    public TestDataBase(String browser) {
        super(browser);
    }

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
    //Подключиться к БД, достанет все из таблицы и выведет все в консоль. Обработает эксепшен.
    //Эксепшен добавили через alt+enter
    //Он подключиться к базе данных выполнит select и выведет в консоль
    public void testWithDB() throws SQLException {
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));
        logger.info(dbMySQL.selectTable("select login from seleniumTable").get(1));
        //Добавили в базу свои данные
        logger.info((dbMySQL.changeDB("Insert into seleniumTable " + "values (13, 'dimaTest', 'pass')")));

        //Удаляем свои данныех которые мы заменили
        logger.info((dbMySQL.changeDB("delete from seleniumTable where login='dimaTest'")));
        logger.info(dbMySQL.selectTable("select * from seleniumTable"));
    }

//        @Test
//    public void CheckingDataInTheTable() throws SQLException {
//        ArrayList dbtable = (ArrayList) dbMySQL.selectTable("select * from seleniumTable where login='Student'");
//        if (dbtable.size() == 1) {
//            dbMySQL.changeDB("INSERT INTO seleniumTable VALUES (null, 'Student', '909090')");
//            logger.info("DB was changed");
//        } else {
//            logger.info("Student is already exist");
//
//        }
//        ArrayList resultTable = (ArrayList) dbMySQL.selectTable("select * from seleniumTable where login='Student'");
//        String loginToSystem = (String) ((ArrayList) resultTable.get(1)).get(2);
//        String passwordToSystem = (String) ((ArrayList) resultTable.get(1)).get(3);
//        loginPage.loginUser(loginToSystem,passwordToSystem);
//    }
//}
    @Test
    public void CheckingDataInTheTable() throws SQLException {
        List check = dbMySQL.selectTable("select * from seleniumTable where login='Student'");
        if (check.size() == 1) {
            logger.info("Student not found. Will insert it");
            dbMySQL.changeDB("INSERT INTO seleniumTable VALUES (null,'Student', '909090')");
        } else {
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
        checkAC("Avatar is not present on Page", homePage.isAvatarPresent(), true);
    }
}