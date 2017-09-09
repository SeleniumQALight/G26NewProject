package pages;

import libs.ActionWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;


/**
 * Created by Dmitriy on 19.07.2017.
 */
//Сюда будем выносить все обищие страницы
public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionWithOurElements actionWithOurElements;

    public ParentPage(WebDriver webDriver) { //Создали конструктор для того чтобы передать webDriver
        this.webDriver = webDriver; //webDriver перетащит webDriver который перейдет из вне
        logger = Logger.getLogger(getClass());
        //создали обьект благодаря которому в каждой Page мы будем с ним работать
        actionWithOurElements = new ActionWithOurElements(webDriver);
        //инициализировать елементы(@FindBy) того класса который к ней обращается через оператор this
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method opens url
     *
     * @param url
     */
    public void open(String url) { //создаем метод open и в него передаем Тип String с именем url
        try {
            webDriver.get(url); //открываем страницу
            logger.info("Page was opened" + url);
        } catch (Exception e) {
            logger.error("Page can not opened" + url);
            //Assert.fail пишет текст в junit ЛОГ который будет использоваться для отчетов, и помимо этого он тест останавливает
            //Assert любой из них при негативном тесте завершает работы теста и пишет красным
            Assert.fail("Page can not opened" + url);
        }
    }

    public void checkTitle(String expectedTitle) { //Метод ищет title
        try {
            Assert.assertThat("Title not matched", webDriver.getTitle(), is(expectedTitle));
        } catch (Exception e) {
            logger.error("Can not work with page");
            Assert.fail("Can not work with page");
        }
    }

    public void checkTitleH1PresentOnPagewithText(String text) {
        actionWithOurElements.checkTextInElement(".//h1", text);
    }
}
