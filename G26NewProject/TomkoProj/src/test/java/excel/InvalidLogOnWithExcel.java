package excel;


import libs.ExcelDriver;
import org.apache.log4j.Logger;
import org.junit.Test;
import pages.LoginInPage;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class InvalidLogOnWithExcel extends ParentTest{
    private ExcelDriver excelDriver; // нам нужен объект excelDriver, подтягиваем его из паки libs (import libs.ExcelDriver;)
    Logger logger = Logger.getLogger(getClass());

    @Test
    public void invalidLogOnWithExcel()
        throws IOException {    //
        excelDriver = new ExcelDriver(); // создаем объект котороый будет работать с ExcelDriver
        Map<String, String> dataSet = excelDriver.getData(".//src//main//java//date//testData.xls)"
                , "validLogOn");
        logger.info(dataSet);

        loginInPage.openLoginPage();
        loginInPage.enterLoginToInput(dataSet.get("login"));
        loginInPage.enterPassWordToInput(("password")); // проверить эту строку
        loginInPage.clickOnSubmitButton();
    }
}
