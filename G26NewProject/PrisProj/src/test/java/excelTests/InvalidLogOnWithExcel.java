package excelTests;

import libs.ExcelDriver;
import org.apache.log4j.Logger;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Dmitriy on 31.07.2017.
 */
public class InvalidLogOnWithExcel extends ParentTest {

    private ExcelDriver excelDriver;
    Logger logger = Logger.getLogger(getClass());

    //Конструктор - используй вебдрайвер обьект который обьявлен в родителе.
    //public InvalidLogOnWithExcel() {}

    //Создаем новый конструктор для параметризированного теста разных браузеров
    public InvalidLogOnWithExcel(String browser) {
        super(browser);
    }

    @Test
    public void invalidLogOnWithExcel() throws IOException { //Маячок что здесь могут срабатывать такие ошибки
        excelDriver = new ExcelDriver();//обьект который будет работать с драйвером
        Map<String, String> dataSet = excelDriver.getData(".//src//main//java//data//testData.xls",
                "validlogOn");
        logger.info(dataSet);

        loginPage.openLoginPage();
        loginPage.enterLoginToInput(dataSet.get("login"));//Найти логин в файле Excel и принять значение
        loginPage.enterPasswordToInput(dataSet.get("pass"));//Найти пасс в файле Excel и принять значение
        loginPage.clickOnSubmitButton();
    }

}
