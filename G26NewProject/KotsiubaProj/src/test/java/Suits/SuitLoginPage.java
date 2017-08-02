package Suits;

import loginTests.InvalidLogOnWithOutPageObject;
import loginTests.validLogOnTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                validLogOnTest.class,
                InvalidLogOnWithOutPageObject.class
        }
)
public class SuitLoginPage {
}
