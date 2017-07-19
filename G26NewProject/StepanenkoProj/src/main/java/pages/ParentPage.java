package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 19.07.2017.
 */
public class ParentPage {
    WebDriver webDriver;
    Logger logger;

    //этот конструктор пробрасывает заданный браузер и прописывает логи в каждом тесте
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());

    }

    public void open (String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened" + url);
        } catch (Exception e) {
            //logger пишет текст в консольи в лог
            logger.error("Page cannot open" + url);
            //assert.fail останавливает тест и пишет лог junit для наших отчетов
            Assert.fail("Page cannot open" + url);
        }
    }
}
