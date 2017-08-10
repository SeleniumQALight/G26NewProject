package mainPack.steps;

import mainPack.pages.DictionaryPage;
import mainPack.pages.HomePage;
import mainPack.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

    DictionaryPage dictionaryPage;
    LoginPage loginPage;
    HomePage homePage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void enterLogin(String login) {
        try {
            loginPage.enterLogin(login);
        } catch (Exception e) {
            System.out.println("enterLogin");
        }
    }

    @Step
    public void enterPassword(String password) {
        try {
            loginPage.enterPassword(password);
        } catch (Exception e) {
            System.out.println("enterPassword");
        }
    }

    @Step
    public void logIn() {
        try {
            loginPage.clickOnSubmit();
        } catch (Exception e) {
            System.out.println("logIn");
        }
    }

    @Step
    public void openLoginPage() {
        try {
            loginPage.open();
        } catch (Exception e) {
            System.out.println("openLoginPage");
        }
    }

    @Step
    public void authentication(String login, String password) {
        try {
            enterLogin(login);
            enterPassword(password);
            logIn();
        } catch (Exception e) {
            System.out.println("authentication");
        }

    }

    @Step
    public void shouldSeeAvatar() {
        try {
            Assert.assertTrue(homePage.isAvatarPresent());
        } catch (Exception e) {
            System.out.println("shouldSeeAvatar");
        }

    }
}