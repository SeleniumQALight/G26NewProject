package suits;

import loginTest.InvalidLogonWithoutPageObject;
import loginTest.ValidLogInTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses
        (
                {
                        ValidLogInTest.class,
                        InvalidLogonWithoutPageObject.class
                }
        )

public class SuitLogInPage
{

}
