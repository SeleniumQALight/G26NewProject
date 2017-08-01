package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SparePage extends ParenPage { //2707
    @FindBy(xpath = ".//*[@href='http://v3.qalight.com.ua/dictionary/spares/edit']") //2707
    private WebElement buttonPlus; //2707


    public SparePage(WebDriver webDriver) { // конструктор, значит в этом классе будет все что есть в ParenPage, так же нам передадут драйвер
        super(webDriver);
    }

    public  void clickOnButtonPlus(){
        actionsWithOurElements.clickOnElement((buttonPlus)); //2707
    }

    public boolean isSpareInList(String nameOfSpare) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfSpare + "']");
    }
}
