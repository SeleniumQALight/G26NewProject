package libs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/*
 *  Class that provides methods for extracting data from Excel tables.
 */
public class ExcelDriver {

    /*
     * Static method that retrieves testing data from multiple data Excel table and returns it
     * as Map collection of key-value pairs. Column Number indicates number of data set. Note, please, that returned values
     * are String. We should take care of value's type by himself when will use
     * data values in the test.
     *
     * Статический метод, который извлекает данные из нескольких таблиц Excel и возвращает их
    *Как набор карт пар ключ-значение. Номер столбца указывает количество наборов данных. Обратите внимание, что возвращаемые значения
    * - String. Мы должны сами позаботиться о типе ценности, когда будем использовать
    * Значения данных в тесте.
     */
    //Static потому что мы будем использовать методы по имени в дальнейшем для Excel
    public static Map getMultipleData(String dataFileName, String sheetName, int columnNumber) throws IOException {
        Map<String, String> testData = new HashMap<String, String>(); //оздаем пустой обьект
        // Create stream for reading from file
        InputStream input = new FileInputStream(dataFileName);
        // Get Excel WorkBook from input stream
        HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));  //Стандартная библтотека для вортбук
        // Get Excel sheet from WorkBook
        HSSFSheet sheet = wb.getSheet(sheetName);//взять все листы в переменную записываем листы

        // Get number of data values
        int dataSize = sheet.getPhysicalNumberOfRows() - 1;//обращается к листу, дай мне количество физических занятых ячеек игнорирует первою строку в екселе
        // Look over the table and put key-value pairs into the Map collection
        //Пройдись от индекса один до dataSize + 1) до конца заполненых и делай следующие
        for (int k = 1; k < (dataSize + 1); k++) {
            HSSFCell keyCell = sheet.getRow(k).getCell(0);
            HSSFCell valueCell = sheet.getRow(k).getCell(columnNumber);
            valueCell.setCellType(HSSFCell.CELL_TYPE_STRING);
            testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue()); //в результирующий testData записали key ключ value
        }

        input.close();
        return testData; //возвращаем в место вызова
    }


    /*
      * Static method that retrieves testing data from Excel table and returns it
      * as Map collection of key-value pairs. Note, please, that returned values
      * are String. We should take care of value's type by himself when will use
      * data values in the test.
      *
      *Статический метод, который извлекает данные из таблицы Excel и возвращает их
       * Как набор карт пар ключ-значение. Обратите внимание, что возвращаемые значения
       * - String. Мы должны сами позаботиться о типе ценности, когда будем использовать
       * Значения данных в тесте.
      */
    public static Map getData(String dataFileName, String sheetName) throws IOException {
        Map<String, String> testData = new HashMap<String, String>();
        // Create stream for reading from file
        InputStream input = new FileInputStream(dataFileName);
        // Get Excel WorkBook from input stream
        HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));
        // Get Excel sheet from WorkBook
        HSSFSheet sheet = wb.getSheet(sheetName);

        // Get number of data values
        int dataSize = sheet.getPhysicalNumberOfRows() - 1;
        // Look over the table and put key-value pairs into the Map collection
        for (int k = 1; k < (dataSize + 1); k++) {
            HSSFCell keyCell = sheet.getRow(k).getCell(0);
            HSSFCell valueCell = sheet.getRow(k).getCell(1);
            valueCell.setCellType(HSSFCell.CELL_TYPE_STRING);
            testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
        }

        input.close();
        return testData;
    }


    /*
     * Static method that retrieves testing data from Excel table and returns it
     * as Map collection of key-value pairs. Note, please, that returned values
     * are String. We should take care of value's type by himself when will use
     * data values in the test.
     *
     * Статический метод, который извлекает данные из таблицы Excel и возвращает их
      * Как набор карт пар ключ-значение. Обратите внимание, что возвращаемые значения
      * - String. Мы должны сами позаботиться о типе ценности, когда будем использовать
      * Значения данных в тесте.
     */
    public static Map getDataRow(String dataFileName, String sheetName) throws IOException {
        Map<String, String> testData = new HashMap<String, String>();
        // Create stream for reading from file
        InputStream input = new FileInputStream(dataFileName);
        // Get Excel WorkBook from input stream
        HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input));
        // Get Excel sheet from WorkBook
        HSSFSheet sheet = wb.getSheet(sheetName);

        // Get number of data values
        int dataSize = sheet.getRow(2).getPhysicalNumberOfCells();
        // Look over the table and put key-value pairs into the Map collection
        for (int k = 0; k < (dataSize); k++) {
            HSSFCell keyCell = sheet.getRow(2).getCell(k);
            HSSFCell valueCell = sheet.getRow(3).getCell(k);
            valueCell.setCellType(HSSFCell.CELL_TYPE_STRING);
            testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
        }

        input.close();
        return testData;
    }
}
