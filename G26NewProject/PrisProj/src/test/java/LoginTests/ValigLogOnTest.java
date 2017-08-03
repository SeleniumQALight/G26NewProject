package LoginTests;

import org.junit.Ignore;
import parentTest.ParentTest;
import org.junit.Test;
import parentTest.ParentTest;
/**
 * Created by Dmitriy on 24.07.2017.
 */

public class ValigLogOnTest extends ParentTest {
	@Test
	//@Ignore //аннотация которая игнорит 1 тест кейс
	public void validLogOn(){
		loginPage.openLoginPage(); //сюда ничего передавать не нужно
		loginPage.enterLoginToInput("Student"); //Логины могут быть разные
		loginPage.enterPasswordToInput("909090"); //Может передавать разные пароли
		loginPage.clickOnSubmitButton(); //Кликнить по кнопке
		checkAC("Avatar is not present on Page",
				homePage.isAvatarPresent(),
				true);
	}
}