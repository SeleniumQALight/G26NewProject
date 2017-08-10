package excelTests;

import libs.ExcelDriver;
import org.apache.log4j.Logger;
import org.junit.Test;
import parrentTest.ParrentTest;

import java.io.IOException;
import java.util.Map;


public class InvalidLogOnWithExcel extends ParrentTest{
    private ExcelDriver excelDriver;
    Logger logger = Logger.getLogger(getClass());
    @Test
    public void invalidLogOnWithExcel() throws IOException {
        excelDriver = new ExcelDriver();
        Map<String,String> dataSet = excelDriver.getData(".//src//main//java//data//testData.xls","validLogOn");
        logger.info(dataSet);
        loginPage.openLoginPage();
        loginPage.enterLoginToInput(dataSet.get("login"));
        loginPage.enterPasswordToInput(dataSet.get("password"));
        loginPage.clickOnSubmitButton();
    }
}
