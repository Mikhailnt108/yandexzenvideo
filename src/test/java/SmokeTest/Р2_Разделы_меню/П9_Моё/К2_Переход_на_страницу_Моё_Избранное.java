package SmokeTest.Р2_Разделы_меню.П9_Моё;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К2_Переход_на_страницу_Моё_Избранное extends TestBase {
    @Test
    public void goToFavoritesPage() {
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
        cardFilm.checkOpenCardFilm();
        cardFilm.clickButtonFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm2FromAll();
        cardFilm.clickButtonFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm3FromAll();
        cardFilm.clickButtonFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm4FromAll();
        cardFilm.clickButtonFavorites();
        headerMenu.goToMyPageFavorites();
        myPage.goToCollectionFavoritesPage();
    }
}
