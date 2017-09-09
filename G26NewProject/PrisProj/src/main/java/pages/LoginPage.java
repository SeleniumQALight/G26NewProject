package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmitriy on 19.07.2017.
 */
public class LoginPage extends ParentPage {

	@FindBy(name = "_username") //Аннотация которая ищет по указанному признаку, работает с елементами Page
	private WebElement loginInput; // Создаем обьект по тому что искали сверху

	@FindBy(id = "password")
	private WebElement inputPass;

	@FindBy(xpath = ".//button")
	private WebElement buttonSubmit;

	public LoginPage(WebDriver webDriver) { //Мы передадим webDriver там где мы создаем/тестов
		super(webDriver); //его мы передадим в родительский класс ParentPage

	}

	public void openLoginPage() {
		//Вызов метода open который открывает url
		open("http://v3.qalight.com.ua/");
	}

	/**
	 * Method input login to input
	 * @param login
	 */
	public void enterLoginToInput(String login) {
		actionWithOurElements.enterText(loginInput, login);
		//       try {
		//           loginInput.sendKeys(login);
		//webDriver.findElement(By.xpath(".//input[@class='form-control' and @placeholder='Email']")).sendKeys(login);
		//          logger.info(login + " was inputed into Input Login");
		//     } catch (Exception e) {
		//         logger.error("Can not work with input");
		//         Assert.fail("Can not work with input");
	}

	/**
	 * Method input Password to input
	 * @param password
	 */
	public void enterPasswordToInput(String password){ //метод который будет передавать пароль
		actionWithOurElements.enterText(inputPass, password);

	}

	/**
	 * Method click submit button
	 */
	public void clickOnSubmitButton() { //метод кликает на кнопку ничего передавать не будем
		actionWithOurElements.clickOnElement(buttonSubmit);
	}

	public boolean isElementWithTextPresent(String text) { //метод возвращает есть ли элемент на этой странице

		return actionWithOurElements.isElementPresent(".//*[contains(text),'+text+')]");
	}

	public void loginUser(String login, String password) { //Метод который будет работать с тестом addNewSpare

		openLoginPage();
		enterLoginToInput(login);
		enterPasswordToInput(password);
		clickOnSubmitButton();
		checkTitle("Учет запчастей");
	}
}