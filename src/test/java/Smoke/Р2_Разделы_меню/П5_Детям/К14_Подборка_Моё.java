package Smoke.Р2_Разделы_меню.П5_Детям;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К14_Подборка_Моё extends TestBase {
    @Test
    public void collectionOfMy() {
        headerMenu.goToKidsPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpInputPassword.checkOpenFrameInputPassword();
        popUpInputPassword.inputPassword("111111");
        popUpInputPassword.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        kidsPage.clickToTailCardFilm();
        cardFilm.paymentFilmAtEst();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm1FromAll();
        cardFilm.paymentFilmAtEst();
        headerMenu.goToKidsPage();
        kidsPage.clickToHeaderCollectionOfMy();
        collectionPage.checkCollectionOfMy();

    }
}
