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
@RunWith(value = Parameterized.class) // анотация - этот класс будет запускаться с параметрами
public class InvalidLogOnWithDataFromExcel extends ParentTest {
    String login, pass; // Объявляем переменные для параметров

    public InvalidLogOnWithDataFromExcel(String browser, String login, String pass) { // параметры для теста login и pass
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters // блок который будет давать нам параметры для запуска, он их будет брать из excel файла
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls"); // ссылаемся на файл testSuit чтобы проверить несколько значений
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();      //2й параметр - указываем название листа в экселе
    }


    @Test
    public void invalidLogOnWithDataFromExcel() {
        logInPage.openLoginPage();
        logInPage.enterLoginToInput(login);
        logInPage.enterPassWordToInput(pass);
        logInPage.clickOnSubmitButton();
        checkAC("Text 'Учет запчастей' not found",
                logInPage.isElementWithTextPresent("Учет запчастей")
                ,true);
    }



}
