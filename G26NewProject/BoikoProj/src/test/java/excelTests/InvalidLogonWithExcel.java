package excelTests;

import libs.ExcelDriver;
import org.apache.log4j.Logger;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Оля on 31.07.2017.
 */
public class InvalidLogonWithExcel extends ParentTest {
    private ExcelDriver excelDriver;
    Logger logger = Logger.getLogger(getClass());

    public InvalidLogonWithExcel(String browser) {
        super(browser);
    }

    @Test
    public void invalidLogonWithExcel() throws IOException { //Method can work with exception
        excelDriver = new ExcelDriver();  //We can do it in ParentPage if we use it in all tests
        Map<String,String> dataSet = excelDriver.getData(".//src//main//java//data//testData.xls", "validLogOn"); //First param path to Excel file with data
        logger.info(dataSet);

        loginPage.openLoginPage();
        loginPage.enterLoginToInput(dataSet.get("login")); //Find key login in Excel file and take value
        loginPage.enterPasswordToInput(dataSet.get("pass")); //Find key pass in Excel file and take value
        loginPage.pressButtonSubmit();
    }
}
