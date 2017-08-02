package spare;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    @Test
    public void addNewSpare() {
        logInPage.loginUser( "Student", "909090" );
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.checkTitle( "Учет запчастей" );
        sparePage.checkTitleH1PresentOnPageWithText( "Запчасти Список" );
        sparePage.clickOnButtonPlus();
        addNewSparePage.checkTitleH1PresentOnPageWithText( "Словарь" );
        addNewSparePage.enterSpareName( "Spare1" );
        addNewSparePage.selectElementFromDDSpareType( "Датчики івіфв" );
        addNewSparePage.clickButtonCreat();
        sparePage.checkTitleH1PresentOnPageWithText( "Запчасти Список" );
        checkAC( "Can not find spare in list ",
                sparePage.isSpareInList( "Spare1" )
                , true );

    }
}
