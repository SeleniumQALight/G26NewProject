package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by tatyanavolkorezova on 19.07.17.
 */
public class ParentPage {
    WebDriver webDriver;
    Logger logger;


        public ParentPage(WebDriver webDriver) {
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
                logger.info("Page was opened" + url);

            }catch (Exception e){
                logger.error("Page cannot opened"+url);
                Assert.fail("Page cannot opened"+url);

            }
        }

    }


