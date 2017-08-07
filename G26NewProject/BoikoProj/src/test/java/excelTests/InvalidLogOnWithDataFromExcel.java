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
@RunWith(value = Parameterized.class) //jUnit annotation - this class will be run with parameters. Before such class we use RunWith
public class InvalidLogOnWithDataFromExcel extends ParentTest {
    String login, pass;

    public InvalidLogOnWithDataFromExcel(String browser, String login, String pass) { //Browser is not used now
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters //jUnit annotation. Block which give us parameters for run
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls"); // In this variable we copy all content of the file
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();      //2й параметр - указываем название листа в екселе
    }


    @Test
    public void invalidLogOnWithDataFromExcel() {
        loginPage.openLoginPage();
        loginPage.enterLoginToInput(login);
        loginPage.enterPasswordToInput(pass);
        loginPage.pressButtonSubmit();
        checkAC("Text 'Учет запчастей' not found",loginPage.isElementWithTextPresent("Учет запчастей"), true);
    }



}
