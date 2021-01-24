package TestSmoke.Р2_Разделы_меню.П3_Фильмы;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class Test_9_Добавление_в_избранное_фильма extends TestBase {
    @Test
    public void AddingFilmToFavorites() {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.clickButtonFavorites();
        headerMenu.goToMyPageFavorites();
        myPage.checkAddingFilmToFavorites();
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
