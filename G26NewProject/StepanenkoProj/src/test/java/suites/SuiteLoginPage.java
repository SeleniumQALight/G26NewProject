package suites;

import LoginTests.InvalidLogInWithoutPageObject;
import LoginTests.LoginTestWithoutPageObject;
import LoginTests.ValidLogInTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @RunWith(Suite.class) аннотация показывает начало работы со сьютом
 */
@RunWith(Suite.class)
/**
 * @Suite.SuiteClasses аннотация перечисляет все тесты в сьюите
 */
@Suite.SuiteClasses({
        ValidLogInTest.class,
        InvalidLogInWithoutPageObject.class,
        LoginTestWithoutPageObject.class

}

)

public class SuiteLoginPage {
}
