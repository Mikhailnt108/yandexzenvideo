package TestSmoke.Р4_Разделы_меню.П8_Моё;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#2")
public class Test_01_МОЁ_Переход_по_вкладкам_RETEST19 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="1. Переход по вкладкам Моё")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void clickOnTheMyTabs() throws Exception {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToTailCardFilm();
        cardFilm.paymentButtonRent2InCardFilm();
        cardFilm.clickButtonFavorites();
        cardFilm.startVideoPleer();
        myPage.checkAddingFilmInHistory();
        myPage.goToMyPagePurchases();
        myPage.checkAddingFilmInPurchases();
        myPage.goToMyPageFavorites();
        myPage.checkAddingFilmToFavorites();
        pageCMS.deleteAccountMF("79260172279");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
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
