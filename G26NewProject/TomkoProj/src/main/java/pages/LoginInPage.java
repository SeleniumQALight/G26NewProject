package pages;

import org.openqa.selenium.WebDriver;

public class LoginInPage extends ParenPage {
    public LoginInPage(WebDriver webDriver) { //конструктор, тут: в LoginInPage -передаем webDriver с теста
        super(webDriver); //  а эта строка передаст этот же вебдрайвер в ParenTest
    }                      //т.е через все классы должен пройти один и тот же webDriver

    public void openLoginPage(){// в парамитрe ничего не должно быть ,он будет открывать свой url
        open("http://v3.qalight.com.ua/");
    }
}