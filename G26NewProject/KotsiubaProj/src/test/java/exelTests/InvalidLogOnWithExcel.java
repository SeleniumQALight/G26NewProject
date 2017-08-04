package exelTests;

import libs.ExcelDriver;
import org.junit.Test;
import parrentTest.ParrentTest;

import java.io.IOException;
import java.util.Map;
import org.apache.log4j.Logger;

public class InvalidLogOnWithExcel extends ParrentTest{
    // обьявили переменную  прописуем класс
    private ExcelDriver excelDriver;
    Logger logger = Logger.getLogger(getClass());
    @Test
    public void invalidLogOnWithExcel() throws IOException {
        excelDriver = new ExcelDriver();
        Map<String,String> dataSet = excelDriver.getData(".//src//main//java//data//testData.xls", "validLogOn");
    logger.info(dataSet);

    loginPage.openLoginPage();
    loginPage.enterLoginToInput(dataSet.get("login"));
    loginPage.enterPassWordToInput(dataSet.get("pass"));
    loginPage.clickOnSubmitButton();
    }
}
