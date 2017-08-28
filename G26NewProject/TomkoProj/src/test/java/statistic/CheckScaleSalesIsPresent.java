package statistic;

import org.junit.Test;
import parentTest.ParentTest;

public class CheckScaleSalesIsPresent extends ParentTest {
    @Test
    public void checkScaleSalesIsPresent(){
        loginInPage.loginUser("Student","909090");
        homePage.clickOnMenuStatistic();
        statisticPage.checkTitleH1PresentOnPage("Отчет о продажах Список");
        statisticPage.checkSalesChartIsPresent();

        checkAC("Can not find salesChart on the statisticPage",statisticPage.checkSalesChartIsPresent(),true);
    }

}
