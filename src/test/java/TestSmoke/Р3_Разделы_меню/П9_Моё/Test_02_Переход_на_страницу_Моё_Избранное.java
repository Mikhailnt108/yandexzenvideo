package TestSmoke.Р3_Разделы_меню.П9_Моё;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Переход_на_страницу_Моё_Избранное extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "9. Моё")
    @DisplayName(value ="Переход на страницу Моё_Избранное")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToFavoritesPage() {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToTailCardFilm();
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
        myPage.goToMyPageFavorites();
        myPage.goToCollectionFavoritesPage();
        pageCMS.deleteAccountMF("79260192144");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
