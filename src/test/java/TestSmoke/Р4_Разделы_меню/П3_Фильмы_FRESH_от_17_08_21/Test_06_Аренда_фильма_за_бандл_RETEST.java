package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_17_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_06_Аренда_фильма_за_бандл_RETEST extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="6. Аренда фильма за бандл")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void PaymentFilmForRent2Promo() throws Exception {
        headerMenu.goToFilmsPage();
        flowRegistation();
        pageCMS.chooseBundleInternetMFromMsisdn("79260192144");
        filmsPage.clickOnFiltrPayment();
        filmsPage.chooseTabPromo();
        filmsPage.clickToTailCardFilmFromAvailable();
        cardFilm.paymentFilmAtRent2Promo();
        cardFilm.startVideoPleer();
        cardFilm.checkСounterAvailableFilms();
        pageCMS.chooseBundleNotSelected("79260192144");
        pageCMS.deleteAccountMF("79260192144");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
