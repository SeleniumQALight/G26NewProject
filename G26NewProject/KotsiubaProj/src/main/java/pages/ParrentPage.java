package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;

public class ParrentPage {
    WebDriver webDriver;
    Logger logger;

    //это конструктор
    public ParrentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }



    /**
     * метод + параметр который передаеться на все, поетому String
     * Method open url
     * @param url
     */
    public void open(String url){
        try{
            // log всегда пишем после действия
            webDriver.get(url);
            logger.info("Page has been opened" + url);
            // Это если урл не откроеться
        } catch (Exception e){
            logger.error("Page can't be open" + url);
            // Assert.fail - Это коллектор метрики и выводит сообщение
            Assert.fail("Page can't be open" + url);
        }

    }
}
