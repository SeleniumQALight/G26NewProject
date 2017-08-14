package suits;

import loginTests.InvalidLogOnWithoutPageObject;
import loginTests.ValidLogOnTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Oliinyk on 01.08.2017.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ValidLogOnTest.class,
                InvalidLogOnWithoutPageObject.class

        }
)
public class SuitLoginPage {
}
