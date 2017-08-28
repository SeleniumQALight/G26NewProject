package workers;


import org.junit.Test;
import parentTest.ParentTest;

public class AddNewNameWorker extends ParentTest {
    @Test
    public void addNewNameWorker(){
        loginInPage.loginUser("Student", "909090");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuWorkers();
        workersPage.ckeckTitle("Учет запчастей");
        workersPage.checkTitleH1PresentOnPage("Сотрудники Список");
        workersPage.clickOnFirstCell();
        addNewWorkersPage.checkTitleH1PresentOnPage("Словарь");
        addNewWorkersPage.enterWorkerSurname("Petrushenko");
        addNewWorkersPage.enterWorkerName("Ivan");
        addNewWorkersPage.enterWorkerMiddleName("Olegovich");
        addNewWorkersPage.clickOnButtonSave();

        checkAC("Can not edit workerName",workersPage.isNewWorkerNameEdited("Petrushenko Ivan Olegovich"),true);
    }

}
