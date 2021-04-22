package TestSmoke.Р3_Разделы_меню.П3_Фильмы;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_04_Покупка_фильма_со_скидкой extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Покупка фильма со скидкой")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void paymentFilmWithDiscount() throws Exception {
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        pageCMS.createPriseEstOrRent2WithDiscount();
        flowRegistation();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkStikerDiscount();
        cardFilm.checkPriseEstDiscount();
        cardFilm.paymentFilmAtEstDiscount();
        cardFilm.checkUnavailabilityStikerDiscount();
        cardFilm.startVideoPleer();
        pageCMS.deleteDiscount();
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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
