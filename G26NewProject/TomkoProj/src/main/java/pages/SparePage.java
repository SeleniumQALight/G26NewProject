package pages;

import org.openqa.selenium.WebDriver;


public class SparePage extends ParenPage {
    public SparePage(WebDriver webDriver) { // конструктор, значит в этом классе будет все что есть в ParenPage, так же нам передадут драйвер
        super(webDriver);
    }
}
