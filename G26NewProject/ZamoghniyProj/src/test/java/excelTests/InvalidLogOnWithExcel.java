package excelTests;

import libs.ExcelDriver;


import org.apache.log4j.Logger;
import org.junit.Test;
import parentTest.ParentTest;


import java.io.IOException;
import java.util.Map;


/**
 * Created by Asus on 31.07.2017.
 */
public class InvalidLogOnWithExcel extends ParentTest {

private ExcelDriver excelDriver;

@Test
public void invalidLogOnWithExcel() throws IOException {

    excelDriver = new ExcelDriver();
    Map<String,String> dataSet = excelDriver.
            getData(".//src//main//java//data//testData.xls","validLogOn");
    //logger.info(dataSet);

    loginPage.enterLoginToInput(dataSet.get("login"));
    loginPage.enterPasswordToInput(dataSet.get("pass"));
    loginPage.clickOnSubmitButton();
    checkAC("Avatar is not Present on Page",homePage.isAvatarPresent(),true);

}
}