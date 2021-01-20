package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К10_Выставление_оценки_ДОТОЧИТЬ_ПРОВЕРКУ_ЛАЙКОВ_НЕТ_ПРОВЕРКИ_СЧЕТЧИКОВ extends TestBase {
    @Test
    public void ratingFilm() {
        headerMenu.goToFilmsPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        popUpInputPhone.checkOpenFrameInputPhone();
        popUpInputPhone.inputLogin("9260192144");
        popUpInputPhone.clickToNext("Далее");
        popUpCreatePassword.checkOpenFrameCreatePassword();
        popUpCreatePassword.inputPassword("111111");
        popUpCreatePassword.clickToComeIn("Войти");
        popUpInputCod.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        popUpInputCod.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        filmsPage.clickToTailCardFilm1FromAll();
        cardFilm.checkOpenCardFilm();
        cardFilm.clickToLikeButton();
        cardFilm.clickToDisLikeButton();
        pageCMS.deleteAccount();
    }
}
