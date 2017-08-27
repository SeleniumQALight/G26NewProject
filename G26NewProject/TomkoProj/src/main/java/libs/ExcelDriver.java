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
	 */
	public static Map getMultipleData(String dataFileName, String sheetName, int columnNumber) throws IOException {
		//getMultipleData статический м-д кот. можем вызывать по имени;
		//(dataFileName -название файла с тестовыми данными, sheetName-название листа в Excel,  columnNumber- имя колонки( в этом листе) в кот.получить данные))
		//на выходе получаем Map (мапка): ключ, значение (логин, Student), (password, 909090)
		Map<String, String> testData = new HashMap<String, String>(); // testData -объект, он в начале пустой
		// Create stream for reading from file
		InputStream input = new FileInputStream(dataFileName); //FileInputStream - встроенная библиотека
		//dataFileName -даем путь к файлу; библиотетка  открівает файл для работі с ним,
		// Get Excel WorkBook from input stream
		HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(input)); // в переменной wb  хранится Workbook
		// Get Excel sheet from WorkBook
		//HSSFWorkbook - библиотека по работе с WorkBook=(это все тот же файл Excel)
		//на вход даем открытый файл ексель как input и говориим преобразуй его в WorkBook и разбери на листы (sheets)
		// и запиши все в переменную wb
		HSSFSheet sheet = wb.getSheet(sheetName); //getSheet -м-д взять листы, sheetName - сюда передаем тот лист который нас инетресует, т.е имя листа нашего теста
		// в переменной sheet будет храниться все что естьна листе(sheetName)
		// Get number of data values
        int dataSize = sheet.getPhysicalNumberOfRows() - 1; //этот метод дает все то что заполнено в файле Excel,
		// т.е все физически  занятые строки (включая заголовки колонок),
		// тут менять цифру (-1) в зависимости от строк для заголовка
		//чтобы была проигнорирована строка с заголовком устанавливают цифру  минус(-n), n-колво строк заголовка
		// Look over the table and put key-value pairs into the Map collection
		for (int k = 1; k < (dataSize + 1); k++) { // возьмет данные от индекса 1 до конца заполненных
			HSSFCell keyCell = sheet.getRow(k).getCell(0); //обращаемся к листу sheetб у тебя есть строка с индексом(getRow с индексом k)
			//и говорим kеуСell, возьми getCell колонку 1-ю, ниже обращаемся к valueCell
			HSSFCell valueCell = sheet.getRow(k).getCell(columnNumber);
			// возьми в той же колонке что и kеу , значение value, columnNumber- номер который мы передали (тут пара мапки для теста)
			valueCell.setCellType(HSSFCell.CELL_TYPE_STRING); // setCellType -привести эти типы к стринге
			testData.put(keyCell.getStringCellValue(), valueCell.getStringCellValue()); // testData сюда записали значения мапки
		}

		input.close();// закрытие файла
		return testData; //возвращение к месту вызова
	}


    /*
      * Static method that retrieves testing data from Excel table and returns it
      * as Map collection of key-value pairs. Note, please, that returned values
      * are String. We should take care of value's type by himself when will use
      * data values in the test.
      */
    public static Map getData(String dataFileName, String sheetName) throws IOException { // даем на входе (имя файла, имя листа),
		// берет 1-ю колонку как key, 2-ю как value; все остальные колонки для м-да не существуют, остальные колонки для комментариев;
		// внутри (в цикле for) зашитое что 0 колонка это key, 1 колонка-value
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
