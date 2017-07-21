package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by admin on 19.07.2017.
 */
public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;

    //этот конструктор пробрасывает заданный браузер и прописывает логи в каждом тесте
    // у конструктора имя такое же как и в классе но нет возвращаемого значения
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElements = new ActionsWithOurElements(webDriver);

        //эта строка создает физичeски все объекты (через @find By) того класса который к ней обращается
        // (через оператор this)
        // каждый @find by этой строчкой создает объект
        // вспомогательные библиотеки хрнаятся в libs (все что не package, и не test)
        PageFactory.initElements(webDriver,this);
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
