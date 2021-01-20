package SmokeTest.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К1_Покупка_фильма extends TestBase {
    @Test
    public void paymentFilm() throws Exception {
        headerMenu.goToFilmsPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        headerMenu.goToMyPagePurchases();
        myPage.checkNoPurchase();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilmFromAvailable();
        cardFilm.checkOpenCardFilm();
        cardFilm.paymentFilmAtEst();
        cardFilm.startVideoPleer();
        headerMenu.goToMyPagePurchases();
        myPage.checkAddingFilmInPurchases();

    }
}
