package excelTests;


import libs.ExcelDriver;
import org.apache.log4j.Logger;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class InvalidLogOnWithExcel extends ParentTest {
    private ExcelDriver excelDriver;
    Logger logger = Logger.getLogger(getClass());
    @Test
    public void invalidLogOnWithExcel () throws IOException { // маячок, что может быть exception, но мы его не обрабатываем
        excelDriver = new ExcelDriver();
        Map<String, String> dataSet = excelDriver.getData(".//src//main//java//data//testData.xls",
                "ValidLogOn");// создаем набор данных (dataSet) с абстрактным типом Мар и передаем в него путь к файлу и название листа в этом файле
        logger.info(dataSet);
        logInPage.openLoginPage();
        logInPage.enterLoginToInput(dataSet.get("login")); // говорим для dataSet по какому key взять value
        logInPage.enterPassWordToInput(dataSet.get("pass")); //говорим для dataSet по какому key взять value
        logInPage.clickOnSubmitButton();

    }


}
