package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmitriy on 13.08.2017.
 */
public class ProvidersPage extends ParentPage { //Создали страницу Словарь и он наследуется от Парентпейдж

    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/providers/edit']")
    private WebElement buttonPlus;

    public ProvidersPage(WebDriver webDriver) {//Пробрасываем webDriver
        super(webDriver);
    }

    public void clickOnButtonPlus() {
        actionWithOurElements.clickOnElement(buttonPlus);
    }

    public void clickOnProvider(String nameOfProvider) {
        actionWithOurElements.clickOnElement(".//*[text() = '" + nameOfProvider + "']");
    }

    public boolean isProviderPrivatePerson(String nameOfProvider) {
        Boolean providerIsPresent = actionWithOurElements.isElementPresent(".//*[text() = '" + nameOfProvider + "']");
        if (providerIsPresent) {
            try {
                logger.info("Provider is private person");
                //Возвращаем драйверу найти элемент по такому Локатору имя + локатор который переходит на страницу Словарь
                return webDriver.findElement(By.xpath(".//*[text()='" + nameOfProvider + "']/..//span[@class='label label-success']")).getText().equals("1");
            } catch (Exception e) {
                logger.error("Can not work with provider");
                Assert.fail("Can not work with provider");
                return false;
            }
        } else {
            logger.error("Provider is not present: " + nameOfProvider);
            return false;
        }
    }
}
