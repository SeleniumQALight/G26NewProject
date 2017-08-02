package excelTests;

import libs.ConfigData;
import libs.SpreadsheetData;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

//this test will run with parameters
// с аннотацией @Parameterized.Parameters junit будет знать , что этот класс будет ранаться
// с некоторыми параметрами несколько раз

/**
 * РАБОТА С ПАРАМЕТРИЗИРОВАННЫМИ ДАННЫМИ
 * МОЖНО УКАЗАТЬ МАССУ ЗНАЧЕНИЙ ДЛЯ ТЕСТОВ В ЭКСЕЛЕ И АВТОМАТОМ ОНИ ЗАПУСКАЮТСЯ
 * КАЖДЫЙ РАЗ ОТКРЫВАЯ И ЗАКРЫВАЯ БРАУЗЕР
 * АВТОМАТИЧЕСКИ РАНАЮТСЯ ТЕСТ СЬЮТЫ С РАЗНЫМИ ЗНАЧЕНИЯМИ
 */
@RunWith(value = Parameterized.class)
public class InvalidLogOnWithDataFromExcel extends ParentTest {
    String login, pass;

    public InvalidLogOnWithDataFromExcel(String browser, String login, String pass) {
        // this.login/this.pass -
        // это параметры метода public InvalidLogOnWithDataFromExcel(String browser, String login, String pass)
        //которые приходят из вне
        this.login = login;
        this.pass = pass;
    }

/** @Parameterized.Parameters дает разные параметры для запуска теста
    **/
    @Parameterized.Parameters
    public static Collection testData() throws IOException {

        /**
         * первый параметр дай мне все данные из файла
         */
        InputStream spreadsheet = new FileInputStream
                (ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
        /**
         * 2й параметр - указываем название листа в екселе
         */
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();

    }


    @Test
    public void invalidLogOnWithDataFromExcel() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput(login);
        logInPage.enterPassWordToInput(pass);
        logInPage.clickOnSubmitButton();
        checkAC("Text 'Учет запчастей' not found",
                logInPage.isElementWithTextPresent("Учет запчастей")
                , true);
    }
}
