package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_4_Покупка_фильма_со_скидкой extends TestBase {
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
        pageCMS.deleteAccount();
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
