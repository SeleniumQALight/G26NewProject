package suites;

import LoginTests.InvalidLogOnWithOutPageObject;
import LoginTests.ValidLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ValidLoginTest.class,
                InvalidLogOnWithOutPageObject.class
        }
)

public class SuiteLoginPage {
}
