package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Аренда_фильма_за_деньги extends TestBase {
    @Test
    public void PaymentFilmForRent2() throws Exception {
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
        filmsPage.clickToHeaderRent2Collection();
        collectionPage.checkOpenCollectionRent2Page();
        collectionPage.clickToTailFilmRent2();
        cardFilm.paymentButtonRent2InCardFilm();
        cardFilm.startVideoPleer();
    }
}
