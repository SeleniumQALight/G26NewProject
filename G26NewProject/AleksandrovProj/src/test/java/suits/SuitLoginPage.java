package suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spare.AddNewSpare;
import loginTests.InvalidLogOnWithoutPageObject;
import loginTests.ValidLoginTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ValidLoginTest.class,
                InvalidLogOnWithoutPageObject.class,
                AddNewSpare.class
        }
)
public class SuitLoginPage {

}
