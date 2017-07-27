package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;


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
    public  void checkTitle(String expectedTitle){
        try {
            Assert.assertThat("Title not matched", webDriver.getTitle(),is(expectedTitle));
        }catch (Exception e){
            logger.error( "Can not work with page "  );
            Assert.fail("Can not work with page");
        }

    }
public void checkTitleH1OnPage(String text){
        actionsWithOurElements.checkTextInElement(".//h1",text);
}

}
