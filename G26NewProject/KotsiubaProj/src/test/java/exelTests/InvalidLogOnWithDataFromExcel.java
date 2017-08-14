package exelTests;



import libs.ConfigData;
import libs.SpreadsheetData;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parrentTest.ParrentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

//this test will run with parameters
// Этот класс будет раниться с параметрами. Junit - будет знать что этот класс нужно будет запустить несколько раз
@RunWith(value = Parameterized.class)
public class InvalidLogOnWithDataFromExcel extends ParrentTest {
    String login, pass;

    public InvalidLogOnWithDataFromExcel(String browser, String login, String pass) {

        this.login = login;
        this.pass = pass;
    }

    // Junit
    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();      //2й параметр - указываем название листа в екселе
    }


    @Test
    public void invalidLogOnWithDataFromExcel() {
        loginPage.openLoginPage();
        loginPage.enterLoginToInput(login);
        loginPage.enterPassWordToInput(pass);
        loginPage.clickOnSubmitButton();
        checkAC("Text 'Учет запчастей' not found", loginPage.isElementWithTextPresent("Учет запчастей")
                , true);
    }



}
