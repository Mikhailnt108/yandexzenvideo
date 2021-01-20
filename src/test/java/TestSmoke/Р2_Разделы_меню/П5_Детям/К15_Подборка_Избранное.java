package TestSmoke.Р2_Разделы_меню.П5_Детям;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К15_Подборка_Избранное extends TestBase {
    @Test
    public void collectionOfFavorites() {
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
        cardFilm.checkOpenCardFilm();
        cardFilm.clickButtonFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm1FromAll();
        cardFilm.clickButtonFavorites();
        headerMenu.goToKidsPage();
        kidsPage.clickToHeaderCollectionOfFavorites();
        collectionPage.checkCollectionOfFavorites();
    }
}
