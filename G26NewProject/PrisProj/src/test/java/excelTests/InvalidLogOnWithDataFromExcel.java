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
//Тот вариант который нужнозапустить с несколькими наборами данных

@RunWith(value = Parameterized.class)
//Аннотация этот класс будет запущен с какими то параметрами будет запущен несколько раз

public class InvalidLogOnWithDataFromExcel extends ParentTest {
    String login, pass; //Обьявляется переменные

    //конструктор с параметрами, сколько параметров в тесте столько будете использовать
    public InvalidLogOnWithDataFromExcel(String browser, String login, String pass) {
        this.login = login; // Логин String login будет равен тому что прийдет с этих параметров
        this.pass = pass;
    }

    //Аннтоция это блок который будет давать нам параметри для запуска
    //Создаем переменную которая втунри себя будет держать значения testDataSuit.xls
    //Обращаемся к классу возьми с файла имя листа и дай нам эти наборы
    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();      //2й параметр - указываем название листа в екселе
    }

    //
    @Test
    public void invalidLogOnWithDataFromExcel() {
        loginPage.openLoginPage();
        loginPage.enterLoginToInput(login);
        loginPage.enterPasswordToInput(pass);
        loginPage.clickOnSubmitButton();
        checkAC("Text 'Учет запчастей' not found",
                loginPage.isElementWithTextPresent("Учет запчастей"),true);
    }
}
