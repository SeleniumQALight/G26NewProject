package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Asus on 19.07.2017.
 */
public class ParentPages {
    WebDriver webDriver;
    Logger logger;
    public ParentPages(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Methods open url
     * @param url
     */
    public void open(String url){
        try{
            webDriver.get(url);
            logger.info(" page was opened" + url);
        }catch (Exception e){
            logger.error( "Page can not opened" + url);
            Assert.fail("Page can not opened" + url);
        }

    }

    public void buttonClick(){
        try{
            webDriver.findElement(By.xpath(".//button")).click();
            logger.info("button was clicked ");
        }catch(Exception e){
            logger.info("button can not clicked");
            Assert.fail("button can not clicked");
        }
    }
    }

