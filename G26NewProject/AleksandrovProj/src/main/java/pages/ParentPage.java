package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by andrey.aleksandrov on 19.07.2017.
 */
public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger( getClass() );
        PageFactory.initElements( webDriver, this );
        actionsWithOurElements = new ActionsWithOurElements( webDriver );
    }

    /**
     * Method opens url with webDriver
     *
     * @param url
     */
    public void open(String url) {
        try {
            webDriver.get( url );
        } catch (Exception e) {
            logger.error( "Page not opened " + url );
            Assert.fail( "Page not opened " + url );
        }
    }

    public void ckeckTitle(String expectedTitle){
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
