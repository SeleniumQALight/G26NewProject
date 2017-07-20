package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Asus on 19.07.2017.
 */
public class ParentPages {
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;

    public ParentPages(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        PageFactory.initElements(webDriver, this); // инициализирует создание Файнд Бай и Веб элементы в текущем пейдже
    }

    /**
     * Methods open url
     * @param url
     */
    public void open(String url){
        try{
            webDriver.get(url);
            logger.info(" page was opened" + url);
        }catch (Exception e){
            logger.error( "Page can not opened" + url);
            Assert.fail("Page can not opened" + url);
        }

    }


    }

