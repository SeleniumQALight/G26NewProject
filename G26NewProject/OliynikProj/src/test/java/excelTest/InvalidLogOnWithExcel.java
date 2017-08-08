package excelTest;

import libs.ExcelDriver;
import org.apache.log4j.Logger;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Oliinyk for Excel DB on 31.07.2017.
 */
public class InvalidLogOnWithExcel extends ParentTest {
    private ExcelDriver excelDriver;
    Logger logger = Logger.getLogger(getClass());
    @Test

    public void invalidLogOnWithExcel ()throws IOException{
    excelDriver = new ExcelDriver();
        Map<String, String> dataSet = excelDriver.getData(".//src//main//java//data//testData.xls", "validLogOn");
logger.info(dataSet);
logInPage.openLoginPage();
logInPage.enterLoginToInput(dataSet.get("login"));
logInPage.enterPasswordIntoElement(dataSet.get("pass"));
logInPage.clickOnSubmitButton();
    }
}
