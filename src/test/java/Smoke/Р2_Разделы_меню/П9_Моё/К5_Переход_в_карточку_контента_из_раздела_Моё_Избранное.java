package Smoke.Р2_Разделы_меню.П9_Моё;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К5_Переход_в_карточку_контента_из_раздела_Моё_Избранное extends TestBase {
    @Test
    public void goToContentCardFromFavorites() {
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
        filmsPage.clickToTailCardFilm1FromAll();
        cardFilm.clickButtonFavorites();
        headerMenu.goToMyPageFavorites();
        myPage.clickToTailCardFilmFromFavorites();
        cardFilm.checkOpenCardFilm();
    }
}
