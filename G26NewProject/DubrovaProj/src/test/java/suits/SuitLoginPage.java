package suits;

import LoginTests.InvalidLogOnWithoutPageObject;
import LoginTests.ValidLogOnTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ValidLogOnTest.class,
                InvalidLogOnWithoutPageObject.class
        }
)

public class SuitLoginPage {

}
