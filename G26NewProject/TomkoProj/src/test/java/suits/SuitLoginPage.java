package suits;

import LoginTests.InvalidLogOnWithOutPageObject;
import LoginTests.LoginTestWithOutPageObject;
import LoginTests.ValidLogOnTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( // тут перечислены все классы кот. входят в этот сьют (через запятую)
        {
                LoginTestWithOutPageObject.class,
                InvalidLogOnWithOutPageObject.class, ValidLogOnTest.class

        }
)

public class SuitLoginPage {

}
