package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends ParentPage {
    @FindBy(name = "_username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement inputPass;

    @FindBy(xpath = ".//button")
    private WebElement buttonSubmit;

    public LogInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        open("http://v3.qalight.com.ua/");
    }

    /**
     * Method input login to input
     *
     * @param login
     */
    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText(loginInput, login);
    }

    public void enterPassWordToInput(String passWord) {
        actionsWithOurElements.enterText(inputPass, passWord);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    public boolean isElementWithTextPresent(String text) {

        return actionsWithOurElements.isElementPresent(".//*[contains(text(),'" + text + "')]");
    }
}
