package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_2_Аренда_фильма_за_деньги extends TestBase {
    @Test
    public void PaymentFilmForRent2() throws Exception {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToHeaderRent2Collection();
        collectionPage.checkOpenCollectionRent2Page();
        collectionPage.clickToTailFilmRent2();
        cardFilm.paymentButtonRent2InCardFilm();
        cardFilm.startVideoPleer();
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
