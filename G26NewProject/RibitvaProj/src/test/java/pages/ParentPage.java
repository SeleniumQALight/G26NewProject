package pages;


import libs.ActionsWithOurElement;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;

public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElement actionsWithOurElement;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElement = new ActionsWithOurElement(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method open url
     *
     * @param url
     */
    public void open(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {
            logger.error("Page can not opened" + url);
            Assert.fail("Page can not opened" + url);
        }
    }

    public void ckeckTitle (String expectedTitle){
        try {
            Assert.assertThat("Title not matched",
            webDriver.getTitle(),
            is (expectedTitle));
        }catch (Exception e){
            logger.error("Can not work with page");
            Assert.fail("Can not work with page");
        }
    }

    public void checkTitleH1PresentOnPageWithText (String text){
        actionsWithOurElement.checkTextInElement(".//H1",text);
    }
}

