package parentTest;

import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Dmitriy on 17.07.2017.
 */
//Создаем обьекты страниц пейджей
public class ParentTest {
	public WebDriver webDriver; //Обьявили модификатором public чтобы был доступен в обоих package(инкапсуляция)
	private Logger logger = Logger.getLogger(getClass());
	private Utils utils = new Utils(); //Обьявили обьект для снятия скринов
	private String pathToScreenShot; //Переменная для изменяемого пути к файлу

	public boolean isTestPass = false; //обьявили меременную для скрина что тест не прошел

	public LoginPage loginPage; //обьявили переменную loginPage
	public HomePage homePage; //обьявили переменную homePage
	public SparePage sparePage; //обьявили переменную sparePage
	public AddNewSparePage addNewSparePage;
	public ProvidersPage providersPage; //обьявили переменную providersPage
	public AddNewProvidersPage addNewProvidersPage;
	//Конструктор передает во внутрь класса, настроить обьект. передаем обьект с одного класса в другом
	//работай с обьектом этого класса
	public ParentTest() {
	}
	
	@Rule //аннотация  которая позволяет получить информацию о тесте который сейчас запущен и получить его имя
	public TestName testName = new TestName();
	
	@Before
	public void setUp() {
		//Мы создали обьект файлы без пути для того чтобы потом спросить нас о пути
		File file = new File("");
//Этот метод создает путь к папкам которые мы создали папку с именем , пекедж с именем, имя файла и его разширение
		pathToScreenShot = file.getAbsolutePath() + "\\target\\screenshot\\"
				+ this.getClass().getPackage().getName() + "\\"
				+ this.getClass().getSimpleName() + "\\" + this.testName.getMethodName() + ".jpg";
		
		File fileFF = new File(".././drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage = new LoginPage(webDriver); //Передали в loginPage webDriver с которым мы будем пользоваться
		homePage = new HomePage(webDriver); //Передали в homePage webDriver с которым мы будем пользоваться
		sparePage = new SparePage(webDriver);//Передали в sparePage webDriver с которым мы будем пользоваться
		addNewSparePage = new AddNewSparePage(webDriver);
		providersPage = new ProvidersPage(webDriver); //Передали в providersPage webDriver с которым мы будем пользоваться
		addNewProvidersPage = new AddNewProvidersPage(webDriver);
	}
	
	@After
	public void tearDown() {
		if (!(webDriver == null)) { //Если дравера нету но ничего закрывать
			if (!isTestPass) {
				//Только в случаи false если тест упадет
				utils.screenShot(pathToScreenShot, webDriver); //при каждом закрытии драйвера снимать скрин
			}
			//webDriver.quit();
		}
	}
	
	/**
	 *
	 * @param messege
	 * @param actualResult
	 * @param expectedResult
	 */
	//Создаем метод Аксептес кретерии с типами и переменными для сравнение Фактического и Ожидаемого результата
	public void checkAC(String messege, boolean actualResult, boolean expectedResult) {
		//делает сравнение actualResult с expectedResult заимпортим is - ALT+ENTER выбираем CoreMatchers
		Assert.assertThat(messege, actualResult, is(expectedResult));
		setTestPass();
	}

	private void setTestPass() { //метод в эту переменную записует тру
		isTestPass = true;
	}
}