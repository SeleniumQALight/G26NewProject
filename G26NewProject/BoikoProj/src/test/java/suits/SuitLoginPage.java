package suits;

import LoginTests.InvalidLogOnWithoutPageobject;
import LoginTests.ValidLogOnTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Оля on 01.08.2017.
 */
@RunWith(Suite.class) //Annotation of JUnit for run suite
@Suite.SuiteClasses(
        {
                ValidLogOnTest.class,
                InvalidLogOnWithoutPageobject.class
        }
)

public class SuitLoginPage {

}
