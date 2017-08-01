package providers;

import org.junit.Test;
import parentTest.ParentTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AddNewProvider extends ParentTest{

   @Test
   public void addNewProvider(){
       String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
       String providersName = "Provider " + timeStamp;
       loginPage.loginUser("Student","909090");
       homePage.clickOnMenuDictionary();
       homePage.clickOnSubMenuProviders();
       providersPage.clickOnButtonAdd();
       addNewProviderPage.enterProvidersName(providersName);
       addNewProviderPage.enterProvidersAddress("ProviderAddress");
       addNewProviderPage.checkingCheckboxPP();
       addNewProviderPage.clickButtonCreate();
       checkAC("Cannot find the provider in list", providersPage.isProviderInList(providersName),true);
   }
}
