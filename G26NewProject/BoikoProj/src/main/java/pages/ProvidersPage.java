package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Оля on 31.07.2017.
 */
//public class ProvidersPage extends ParentPage{
//
//    public ProvidersPage(WebDriver webDriver) {
//        super(webDriver);
//    }
//
//    public void clickOnProvider(String nameOfProvider) {
//        actionsWithOurElements.clickOnElement(".//*[text() = '"+nameOfProvider+"']");
//    }
//
//    public void checkTitle(String expectedTitle) {
//        try {
//            Assert.assertThat("Title not matched", webDriver.getTitle(), is(expectedTitle));
//        } catch (Exception e) {
//            logger.error("Can not work with page");
//            Assert.fail("Can not work with page");
//        }
//    }
//
//    public void checkTitleH1PresentOnPageWithText(String text){
//            actionsWithOurElements.checkTextInElement(".//H1", text);
//        }
//
//    public boolean isProviderPrivatePerson(String nameOfProvider) {
//        Boolean providerIsPresent = actionsWithOurElements.isElementPresent(".//*[text() = '" + nameOfProvider + "']");
//        if (providerIsPresent) {
//            try {
//                Assert.assertThat("Provider is not private person", webDriver.findElement(By.xpath("html/body/div[1]/div/section[2]/div/div/div/div[2]/table/tbody/tr[8]/td[4]/span")).getText(), is("1"));
//            } catch (Exception e) {
//                logger.error("Can not work with provider");
//                Assert.fail("Can not work with provider");
//            }
//        }
//        else{
//                logger.error("Provider is not present: " + nameOfProvider);
//            }
//        }
//}
