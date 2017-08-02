package suits;

import LoginTests.InvalidLogOnWithoutPageobject;
import LoginTests.ValidLogInTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spare.AddNewSpare;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ValidLogInTest.class,
                InvalidLogOnWithoutPageobject.class,
                AddNewSpare.class
        }
)
public class SuitLogInPage {
}
