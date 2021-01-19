package Smoke.Р2_Разделы_меню.П3_Фильмы;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К4_Покупка_фильма_со_скидкой extends TestBase {
    @Test
    public void paymentFilmWithDiscount() throws Exception {
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm1FromAll();
        cardFilm.checkOpenCardFilm();
        pageCMS.createPriseEstOrRent2WithDiscount();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        cardFilm.checkStikerDiscount();
        cardFilm.checkPriseEstDiscount();
        cardFilm.paymentFilmAtEstDiscount();
        cardFilm.checkUnavailabilityStikerDiscount();
        cardFilm.startVideoPleer();
    }
}
