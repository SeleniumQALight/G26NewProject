package libs;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by Dmitriy on 24.07.2017.
 */
public class Utils {

	private Logger log;

	public Utils(){ //Создали конструктор для работы с логом
		log = Logger.getLogger(getClass());
	}

	/**
	 * Taking screenshot into .//target// + pathToScreenShot
	 * @param pathToScreenShot
	 * @param driver
	 */
	public void screenShot(String pathToScreenShot, WebDriver driver){ //Метод который делает скрин
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //снимает скрин
		try {
			FileUtils.copyFile(scrFile, new File(pathToScreenShot));
			log.info("ScreenShot: " + pathToScreenShot);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hard wait
	 * @param second
	 */
	public static void waitABit(int second){ //Метод останавливат все процессы в джава
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}