package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by romas on 19.07.2017.
 *метод открывает страницы
 * тут будет все общее. Отсюда будут наследоваться другие пейджи.
 * действие будет выполнено на каждой странице либо каждой страницей
 */
public class ParentPage {

    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver webDriver) { //создаем конструктор через альт + инсерт
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver,this); //будет создавать объект того класса который к ней обращается.
                                                            // Это делается через оператор this
                                                        //все что прописано с помощью FindBy будет создано в объект
        actionsWithOurElements = new ActionsWithOurElements(webDriver);

    }

    public void open (String url){ //метод будет общим и на прием должен принимать урл чтоб уметь открывать страничку
        try {
            webDriver.get(url);
            logger.info("Page was opened" + url);
        }catch (Exception e){
            logger.error("Page is not opened" + url);
            Assert.fail("Page is not opened" + url); //Junit log. Будет использоватсья в отчетах + останавливает тест
        }
    }
}
