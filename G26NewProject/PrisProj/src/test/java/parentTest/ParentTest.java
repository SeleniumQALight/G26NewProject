package parentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitriy on 17.07.2017.
 */
public class ParentTest {
	public WebDriver webDriver; //Обьявили модификатором public чтобы был доступен в обоих package(инкапсуляция)
	public LoginPage loginPage; //обьявили переменную loginPage
	
	//Конструктор передает во внутрь класса, настроить обьект. передаем обьект с одного класса в другом
	//работай с обьектом этого класса
	public ParentTest() {
	}
	
	@Before
	public void setUp() {
		File fileFF = new File(".././drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage = new LoginPage(webDriver); //Передали в loginPage webDriver с которым мы будем пользоваться
	}
	@After
	public void tearDown() {
		webDriver.quit();
	}
	//Создаем метод Аксептес кретерии с типами и переменными для сравнение Фактического и Ожидаемого результата
	public void checkAC(String messege, boolean actualResult, boolean expectedResult){
		//делает сравнение actualResult с expectedResult заимпортим is - ALT+ENTER выбираем CoreMatchers
		Assert.assertThat(messege, actualResult,is(expectedResult));
	}
}