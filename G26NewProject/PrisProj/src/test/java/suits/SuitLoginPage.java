package suits;

import LoginTests.InvalidLogOnWithoutPageObject;
import LoginTests.ValigLogOnTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Dmitriy on 01.08.2017.
 */
//Аннотация junit для запуска Suit в этом класе у нас будет находиться Suit набор тестов
@RunWith(Suite.class)

//Аннотация junit для перечесления тестов в этот набор Suit
@Suite.SuiteClasses(
        {
                ValigLogOnTest.class,
                InvalidLogOnWithoutPageObject.class
        }
)

public class SuitLoginPage {
}
