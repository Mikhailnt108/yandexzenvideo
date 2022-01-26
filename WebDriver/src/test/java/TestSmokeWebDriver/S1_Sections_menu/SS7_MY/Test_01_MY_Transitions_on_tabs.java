package TestSmokeWebDriver.S1_Sections_menu.SS7_MY;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_MY_Transitions_on_tabs extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "9. MY")
    @DisplayName(value ="Transitions_on_tabs")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#3")
    public void clickOnTheMyTabs() throws Exception {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToSecondTailCardFilm();
        cardFilm.paymentFilmAtEst();
        cardFilm.clickButtonFavorites();
        cardFilm.startVideoPleer();
        myPage.checkAddingFilmInHistory();
        myPage.goToMyPagePurchases();
        myPage.checkAddingFilmInPurchases();
        myPage.goToMyPageFavorites();
        myPage.checkAddingSecondFilmToFavorites();
        pageCMS.deleteAccountMF("79260172279");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260172279");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260172279", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260172279");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
