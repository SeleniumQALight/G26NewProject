package excel;



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
@RunWith(value = Parameterized.class) //анатация , значит что класс будет ранится с параметрами
public class InvalidLogOnWithDataFromExcel extends ParentTest {
    String login, pass; // создаем локальную переменную логин и пароль

    public InvalidLogOnWithDataFromExcel(String browser, String login, String pass) {// конструктор,
        // сколько параметров будем использовать столько будет и переменных в (), String browser -тут не используем, поэтому он серенький,
        // но если теститрование в нескольких браузерах то тут укажем имя браузера
        this.login = login;// говорим в контрукторе: что login котрый объявлен в нашем классе (String login, pass;) прийдет из вне с параметрами
        this.pass = pass; //// говорим в контрукторе: что pass котрый объявлен в нашем классе (String login, pass;) прийдет из вне с параметрами
    }

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");// тут указываем где будут браться параметры
        //создаем переменную кот.внутрис себя будет содержать весь файл testDataSuit.xls
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();      //2й параметр - указываем название листа в екселе
    } //тут обращаемся к SpreadsheetData и говорим: возьми с файла лист(и даем имя листа), и дай нам все данные


    @Test
    public void invalidLogOnWithDataFromExcel() {
        loginInPage.openLoginPage();
        loginInPage.enterLoginToInput(login);
        loginInPage.enterPassWordToInput(pass);
        loginInPage.clickOnSubmitButton();
        checkAC("Text 'Учет запчастей' not found",
                loginInPage.isElementWithTextPresent("Учет запчастей"),true);
    }



}
