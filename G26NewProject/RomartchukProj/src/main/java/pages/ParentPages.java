package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPages {
    WebDriver webDriver;
    Logger logger;

    public ParentPages(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
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
            logger.error("Page can  not open " + url);
            Assert.fail("Page can  not open " + url);
        }

    }
}
