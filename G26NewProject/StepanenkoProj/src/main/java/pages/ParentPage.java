package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;

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

    /**
     * Method opens url
     * @param url
     */
    public void open(String url){
        try{
            webDriver.get(url);
            logger.info("Page was opened " + url);
        }catch (Exception e){
            logger.error("Page can not opened " + url);
            Assert.fail("Page can not opened " + url);
        }
    }

    public void checkTitle(String expectedTitle){
        try {
            Assert.assertThat("Title not matched",
                    webDriver.getTitle(),
                    is(expectedTitle));
        }catch (Exception e){
            logger.error("Can not work with page");
            Assert.fail("Can not work with page");
        }
    }

    public void checkTitleH1PresentOnPageWithText(String text){
        actionsWithOurElements.checkTextInElement(".//H1",text);
    }
}
