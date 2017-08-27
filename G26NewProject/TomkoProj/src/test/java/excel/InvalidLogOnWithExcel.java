package excel;


import libs.ExcelDriver;
import org.apache.log4j.Logger;
import org.junit.Test;
import pages.LoginInPage;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class InvalidLogOnWithExcel extends ParentTest{
    private ExcelDriver excelDriver; // т.к. этот тест работает с Excel поэтому нужен объект ExcelDriver , подтягиваем его из паки libs (import libs.ExcelDriver;)
    Logger logger = Logger.getLogger(getClass());//импортим логер apache, строка стандарная, выведет в консоль значение,чтобы мы его видели

    @Test
    public void invalidLogOnWithExcel()
        throws IOException {    // возможно будут ексепшины, throws IOException - обозначает что в данном методе, возможно будут ексепшин, но мы их не обрабатываем
        excelDriver = new ExcelDriver(); // создаем объект котороый будет работать с ExcelDriver
        Map<String, String> dataSet = excelDriver.getData(".//src//main//java//date//testData.xls)" // создаем переменную в которую будут возвращенны вот эти наборы (мапка) данных
                // даем во входные данные (путь к нашему ексель файлу (путь где сохранен в этом проекте, а не не где-то на ПК) и
                , "validLogOn"); // имя листа
        //<String, String> -это тип нашей пары ключ-значение
        // Map<String, String> - это тип из метода по работе с ексель файлами, dataSet-переменая
        //dataSet будет брать через excelDriver данные из ексель файла
        logger.info(dataSet); //выводим инфо в консоль, получили набор всех пар данных что есть в файле
            //ниже общаемся со страниками, это работа с одним надороб данные (ключ-знаечние)
        loginInPage.openLoginPage(); //страничка loginInPage, открой логин страницу
        loginInPage.enterLoginToInput(dataSet.get("login"));//тут подставится знаечние из екселя
        loginInPage.enterPassWordToInput(("pass")); // pass -это ключик из файла (его знаечение 909090)
        loginInPage.clickOnSubmitButton();
    }
}
