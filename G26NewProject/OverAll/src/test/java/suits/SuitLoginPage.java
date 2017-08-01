package suits;

import LoginTests.InvalidLogOnWithoutPageobject;
import LoginTests.ValigLogOnTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spare.AddNewSpare;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ValigLogOnTest.class,
                InvalidLogOnWithoutPageobject.class,
                AddNewSpare.class
        }
)

public class SuitLoginPage {

}
