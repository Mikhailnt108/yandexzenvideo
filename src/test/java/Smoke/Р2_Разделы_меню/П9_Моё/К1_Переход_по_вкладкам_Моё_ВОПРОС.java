package Smoke.Р2_Разделы_меню.П9_Моё;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К1_Переход_по_вкладкам_Моё_ВОПРОС extends TestBase {
    @Test
    public void clickOnTheMyTabs() {
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
        cardFilm.paymentFilmAtEst();
        headerMenu.goToMyPageFavorites();
    }
}
