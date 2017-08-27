package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatisticPage extends ParenPage{
    @FindBy(id="salesChart")
    private WebElement salesChart; //diagramma

    public StatisticPage(WebDriver webDriver) {
        super(webDriver);
    }
    public boolean checkSalesChartIsPresent() {
      return   actionsWithOurElements.isElementPresent(salesChart);
    }
}
