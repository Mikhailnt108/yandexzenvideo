package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К7_Пауза_фильма extends TestBase {
    @Test
    public void testPauseVideoPleer() throws Exception {
        headerMenu.goToNilPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameInputPassword();
        headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        headerMenu.goToMyPageFavorites();
        myPage.clickToTailCardFilmFromFavorites();
        //cardFilm.clickToPauseVideoPleer();
        //cardFilm.clickToPlayVideoPleer();
        //cardFilm.clickToSpaceToVideoPleer();
        cardFilm.clickToLeftButtonMouseToVideoPleer();
    }
}
