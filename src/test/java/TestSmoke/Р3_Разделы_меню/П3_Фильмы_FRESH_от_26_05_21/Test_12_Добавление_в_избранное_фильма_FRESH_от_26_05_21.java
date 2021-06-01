package TestSmoke.Р3_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_12_Добавление_в_избранное_фильма_FRESH_от_26_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Добавление_в_избранное_фильма")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void AddingFilmToFavorites() throws InterruptedException {
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkButtonFavoriteNotAdded();
        cardFilm.clickButtonFavorites();
        cardFilm.checkButtonFavoriteAdded();
        myPage.checkAddingFilmToFavorites();
        pageCMS.deleteAccountMF("79260192144");
    }
    private void flowRegistation() throws InterruptedException {
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
