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

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    //это строка инициализирует элементы той пейджи/того класса, который к ней обращается (т.е. инициализирует те элементы, которые описаны через @FindBy)


    public void open(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {

            logger.error("Page cannot be opened " + url);
            Assert.fail("Page cannot be opened " + url);
        }
    }

    public void checkTitle(String expectedTitle) {
        try {
            Assert.assertThat("Title does not match", webDriver.getTitle(), is(expectedTitle));

        } catch (Exception e) {
            logger.error("Cannot work with page");
            Assert.fail("Cannot work with page");
        }
    }

    public void checkTitleH1PresentOnPageWithText(String text) {
        actionsWithOurElements.checkTextInElement(".//H1", text);
    }
}

