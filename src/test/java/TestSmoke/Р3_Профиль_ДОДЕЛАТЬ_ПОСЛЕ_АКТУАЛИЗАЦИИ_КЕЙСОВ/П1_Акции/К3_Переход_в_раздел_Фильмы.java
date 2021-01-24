package TestSmoke.Р3_Профиль_ДОДЕЛАТЬ_ПОСЛЕ_АКТУАЛИЗАЦИИ_КЕЙСОВ.П1_Акции;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К3_Переход_в_раздел_Фильмы extends TestBase {
    @Test
    public void goToMoviesPromoSection() {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.chooseBundleFromMsisdn("79260192144");
        headerMenu.openSubsectionPromo();
        promoPage.clickButtonGoToFilms();
        filmsPage.checkFilmsPromo();
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
