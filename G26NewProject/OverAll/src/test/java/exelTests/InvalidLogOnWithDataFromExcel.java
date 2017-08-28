package exelTests;



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
@RunWith(value = Parameterized.class)
public class InvalidLogOnWithDataFromExcel extends ParentTest {
    String login, pass;

    public InvalidLogOnWithDataFromExcel(String browser, String login, String pass) {
        super(browser);
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();      //2й параметр - указываем название листа в екселе
    }


    @Test
    public void invalidLogOnWithDataFromExcel() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput(login);
        logInPage.enterPassWordToInput(pass);
        logInPage.clickOnSubmitButton();
        checkAC("Text 'Учет запчастей' not found",
                logInPage.isElementWithTextPresent("Учет запчастей")
                ,true
        );
    }



}
