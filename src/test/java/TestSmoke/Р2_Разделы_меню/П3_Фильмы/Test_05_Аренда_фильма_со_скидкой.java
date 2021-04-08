package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_05_Аренда_фильма_со_скидкой extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Аренда фильма со скидкой")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void rentFilmWithDiscount() throws Exception {
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        pageCMS.createPriseEstOrRent2WithDiscount();
        flowRegistation();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkStikerDiscount();
        cardFilm.checkPriseRent2Discount();
        cardFilm.paymentFilmAtRent2Discount();
        cardFilm.checkUnavailabilityStikerDiscount();
        cardFilm.startVideoPleer();
        pageCMS.deleteDiscount();
        pageCMS.deleteAccountMF();
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
