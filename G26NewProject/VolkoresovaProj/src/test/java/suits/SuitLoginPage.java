package suits;

import LoginTests.InvalidLogOnWithoutPageobject;
import LoginTests.ValidLogOnTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ValidLogOnTest.class,
                InvalidLogOnWithoutPageobject.class,



        }

)
public class SuitLoginPage {

}
