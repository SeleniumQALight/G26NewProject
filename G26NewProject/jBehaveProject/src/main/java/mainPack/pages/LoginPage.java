package mainPack.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary")
public class LoginPage extends PageObject {

    @FindBy(name = "_username")
    private WebElementFacade loginInput;

    @FindBy(name = "_password")
    private WebElementFacade passwordInput;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElementFacade submitButton;

    public void enterLogin(String login) {
        try {
            loginInput.type(login);
        } catch (Exception e) {
            System.out.println("enterLogin");
        }
    }

    public void enterPassword(String password) {
        try {
            passwordInput.type(password);
        } catch (Exception e) {
            System.out.println("enterPassword");
        }
    }

    public void clickOnSubmit() {
        try {
            submitButton.click();
        } catch (Exception e) {
            System.out.println("clickOnSubmit");
        }
    }
}