package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by andrey.aleksandrov on 19.07.2017.
 */
public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;
//konstuktor
    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger( getClass() );
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        //initial elements
        PageFactory.initElements(webDriver,this);
    }

    /**
     * Method opens url with webDriver
     * @param url
     */
    public void open(String url) {
        try {
            webDriver.get( url );
        }catch (Exception e){
            logger.error( "Page not opened " + url  );
            Assert.fail("Page not opened " + url);
        }
    }
}
