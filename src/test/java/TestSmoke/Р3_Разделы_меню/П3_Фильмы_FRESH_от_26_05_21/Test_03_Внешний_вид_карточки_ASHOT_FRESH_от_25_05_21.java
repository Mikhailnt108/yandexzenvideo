package TestSmoke.Р3_Разделы_меню.П3_Фильмы_FRESH_от_26_05_21;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_03_Внешний_вид_карточки_ASHOT_FRESH_от_25_05_21 extends TestBase {
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
//        cardFilm.checkImageDifferCardFilm();
        cardFilm.checkElementsCardFilm();

        // авторизованный пользователь:
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkAutoStartVideoPlayer();
//        cardFilm.checkImageDifferCardFilm();
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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}

