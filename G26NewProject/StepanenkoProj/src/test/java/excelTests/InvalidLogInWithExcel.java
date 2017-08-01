package excelTests;

import libs.ExcelDriver;
import org.apache.log4j.Logger;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

/**
 * Created by admin on 31.07.2017.
 */
public class InvalidLogInWithExcel extends ParentTest{
    private ExcelDriver excelDriver;
    Logger logger = Logger.getLogger(getClass());

    @Test
    /**
     * throws IOException
     * могут возникнуть exceptions
     * так обрабатываются большинство эксепшенов, вместо try/catch
     * Работа с 1
     */
    public void invalidLogInWithExcel () throws IOException {
        excelDriver = new ExcelDriver();
        Map<String, String> dataSet = excelDriver.getData(".//src//main//java//data//testData.xls",
                "validLogOn");
        logger.info(dataSet);

        //dataSet.get("login"), dataSet.get("pass") --> подставится значение с эксель
        /**этим тестом мы можем изменять данные в эксель,
        // а джава будеть ходить в эксель и брать оттуда измененные данные
         **/
        logInPage.openLoginPage();
        logInPage.enterLoginToInput(dataSet.get("login"));
        logInPage.enterPassWordToInput(dataSet.get("pass"));
        logInPage.clickOnSubmitButton();
    }
    /**
     * работы с несколькими наборами данных код в SpreadSheetData
     */
}
