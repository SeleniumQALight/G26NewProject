package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;

public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver webDriver) {
            this.webDriver = webDriver;
            logger = Logger.getLogger(getClass());
            actionsWithOurElements = new ActionsWithOurElements(webDriver);
            PageFactory.initElements(webDriver,this);
    }

    public void open(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened" + url);
        } catch (Exception e){
            logger.error("Page can't be opened" + url);
            Assert.fail("Page can't be opened" + url);
        }
    }

    public void checkTitle(String expectedTitle){
        try {
        Assert.assertThat("Title is not matched",webDriver.getTitle(),is(expectedTitle));
        } catch (Exception e){
            logger.error("Can not work with page");
            Assert.fail("Can not work with page");
        }
    }

    public void chackTitleh1PresentOnPageWithText(String text){
        actionsWithOurElements.checkTextInElement(".//h1", text);
    }

}
