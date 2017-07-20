package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "_username")
    WebElement loginInput;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(xpath = ".//button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver)  {
        super(webDriver);
    }

    public void openloginPage(){
        open("http://v3.qalight.com.ua/");
    }

    public void enterLoginToInput(String login) {


        actionsWithOurElement.enterText(loginInput, login);

//        try {
//            loginInput.sendKeys (login);
//            webDriver.findElement(By.xpath(".//*[@name='_username']")) выше стоящая строка заменяет эти две
//                .sendKeys(login);
//            logger.info(login + " was inputed into Onput Login");
//
//        }catch (Exception e) {
//            logger.error("Can not work with input");
//            Assert.fail("Can not work with input");
//        }
    }

    public  void enterPassWordToInput (String passWord){
        actionsWithOurElement.enterText(inputPass, passWord);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElement.clickOnElement(buttonSubmit);
    }

    public boolean isElementWithTextPresent(String text) {

        return actionsWithOurElement.isElementPresent(".//*[contains(text(),'"+text+"')]");
    }
}
