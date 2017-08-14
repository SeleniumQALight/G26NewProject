package workers;


import org.junit.Test;
import parentTest.ParentTest;

public class AddNewNameWorker extends ParentTest {
    @Test
    public void addNewNameWorker(){
        loginInPage.loginUser("Student", "909090");

    }

}
