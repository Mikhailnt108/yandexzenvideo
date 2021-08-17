package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_17_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_03_1_Внешний_вид_карточки_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="Внешний вид карточки")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void appearanceSectionCardFilm() throws Exception {
        // неавторизованный пользователь:
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkAutoStartVideoPlayer();
        cardFilm.checkElementsCardFilm();

        // авторизованный пользователь:
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkAutoStartVideoPlayer();
        cardFilm.checkElementsCardFilm();
        cardFilm.clickButtonFavorites();
        myPage.checkAddingFilmToFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.clickToButtonReadDescription();
        cardFilm.checkOpenDescriptionAll();
        cardFilm.clickToButtonRollUp();
        cardFilm.checkRollUpDescription();
        cardFilm.clickToLikeButton();
        cardFilm.clickToDisLikeButton();
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
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}

