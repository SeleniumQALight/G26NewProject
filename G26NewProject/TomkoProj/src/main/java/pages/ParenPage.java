package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParenPage {  // сюда выносим все общее что есть на pages
    WebDriver webdriver; // объявили webdriver локальный
    Logger logger; // аппачевский логер выбрать в подсказке, тут объявили ллогер локальный

    public ParenPage(WebDriver webDriver) {  // конструктор, чтоб создать надо навести курсор на ParenPage и нажать Alt+Ins,и в параметры передаем webdriver из вне сюда
      this.webdriver = webDriver;    //     this.webdriver = тому webdriver что в параметре указан и который к нам прийдет из вне
      logger = Logger.getLogger(getClass()); // получи имя класса в котором ты сейчас находишься, этот логер объявлен один раз,  а будет работать во всех pages
                                             // и сам будет получать имя той пейджи где он сейчас находиться
        }

    /**
     * Method opens url, will be available from every pages
     * @param url
     */
    public void open(String url) { //передаем в параметре url т.к будем передатьва разные адреса страниц
                                // т.к. тут нет драйвера нам надо его перед с пакпи test, для этого надо в тесте объявить переменную LoginPage и дать ему тот driver который мы открыли, это делать надо с помощью конструктора
        try{ // попробуй открыть, хорошая ситуация, положительная
            webdriver.get(url); // открываем наш url
            logger.info("Page was opened " + url);

        } catch(Exception e){ // а если ты не смог и поймал какойто Exception
            logger.error("Page can`t open " + url); //если не открылась пейджа выводим ссобщение, это запишется в наш логер
            Assert.fail("Page can`t open " + url); //когда программа доходит до Assert она останавливается и срабатывает Assert сообщение, тест краситься в красный цвет
        } // Assert пишет сообщение в лог тест junit, и мы потом будем использовать его для отчета
     }

   // webDriver.get("http://v3.qalight.com.ua/");//get метод вставляет наш url в строку браузера

}
