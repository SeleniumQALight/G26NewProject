package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.Is.is;

public class ParentPages {
    WebDriver webDriver;
    Logger logger;
 //   WebDriverWait webDriverWait15;
    public ActionsWithOurElements actionsWithOurElements;

    public ParentPages(WebDriver webDriver){
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        PageFactory.initElements(webDriver,this);
      //  webDriverWait15 = new WebDriverWait(webDriver,15);
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
    public void checkTitle(String expectedTitle){
        try {
            Assert.assertThat("Title not matched",
                    webDriver.getTitle(),
                    is(expectedTitle));
        }catch (Exception e){
            logger.error("Can not work with page");
            Assert.fail("Can not work with page");
        }
    }
    public void checkTitleH1PresentOnPageWithText(String text) {
        actionsWithOurElements.checkTextInElement(".//h1", text);
    }
}
