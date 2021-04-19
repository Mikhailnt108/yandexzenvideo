package TestSmoke.Р3_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_03_Аренда_фильма_за_бандл_НЕТ_Фильмов_по_акции_на_ПП1_на_ПП2_есть extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Аренда фильма за бандл")
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
        cardFilm.checkСounterAvailableFilms();
        cardFilm.startVideoPleer();
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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
