package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;



/**
 * Created by Dmitriy on 19.07.2017.
 */
//Сюда будем выносить все обищие страницы
public class ParentPage {
    WebDriver webDriver;
    Logger logger;

    public ParentPage(WebDriver webDriver) { //Создали конструктор для того чтобы передать webDriver
        this.webDriver = webDriver; //webDriver перетащит webDriver который перейдет из вне
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method opens url
     * @param url
     */
    public void open(String url){ //создаем метод open и в него передаем Тип String с именем url
        try {
            webDriver.get(url); //открываем страницу
            logger.info("Page was opened" + url);
        }catch (Exception e){
            logger.error("Page can not opened" + url);
            //Assert.fail пишет текст в junit ЛОГ который будет использоваться для отчетов, и помимо этого он тест останавливает
           //Assert любой из них при негативном тесте завершает работы теста и пишет красным
            Assert.fail("Page can not opened" + url);
        }
    }
}
