package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by andrey.aleksandrov on 19.07.2017.
 */
public class ParentPage {
    WebDriver webDriver;
    Logger logger;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger( getClass() );
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
