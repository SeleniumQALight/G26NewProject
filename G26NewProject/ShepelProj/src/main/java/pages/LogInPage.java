package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends ParentPage {
    @FindBy(name = "_username") // ищем по названию поле
    private WebElement loginInput; // создает объект и записывает в него значение из строки @FindBy(name = "_username")

    @FindBy(id = "password")
    private WebElement inputPass; // создает объект и записывает в него значение из строки @FindBy(id = "password")

    @FindBy(xpath = ".//button")
    private WebElement buttonSubmit; // создает объект и записывает в него значение из строки @FindBy(xpath = ".//button")

    public LogInPage(WebDriver webDriver) { super(webDriver); }

    /**
     * Method input login to input
     * @param login
     */

    public void openLoginPage() {
        open("http://v3.qualight.com.ua/"); }

    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText(loginInput,login); // выбираем alt+enter inputfield
        try{
            loginInput.sendKeys(login);
            logger.info(login + "was inputed into Input Login");
        }catch (Exception e) {
            logger.error("Can ");
        }
    }

    public void enterPasswordToInput(String passWord) {
        actionsWithOurElements.enterText(inputPass,passWord);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }


}
