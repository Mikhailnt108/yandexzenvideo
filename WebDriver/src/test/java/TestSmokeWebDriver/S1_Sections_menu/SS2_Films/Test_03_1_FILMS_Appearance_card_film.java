package TestSmokeWebDriver.S1_Sections_menu.SS2_Films;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_1_FILMS_Appearance_card_film extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Sections_menu")
    @Story(value = "3. Films")
    @DisplayName(value ="Appearance_card_film")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("35669380")
    @Test
    @Tag("SuiteWD#1")
    public void appearanceSectionCardFilm() throws Exception {
        // неавторизованный пользователь:
        headerMenu.goToFilmsPage();
        filmsPage.clickToFirstTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkAutoStartVideoPlayer();
        cardFilm.checkElementsCardFilm();

        // авторизованный пользователь:
        headerMenu.goToFilmsPage();
        flowRegistation();
        filmsPage.clickToFirstTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.checkAutoStartVideoPlayer();
        cardFilm.checkElementsCardFilm();
        cardFilm.clickButtonFavorites();
        myPage.checkAddingFirstFilmToFavorites();
        headerMenu.goToFilmsPage();
        filmsPage.clickToFirstTailCardFilm();
        cardFilm.checkOpenCardFilm();
        cardFilm.clickToButtonReadDescription();
        cardFilm.checkOpenDescriptionAll();
        cardFilm.clickToButtonRollUp();
        cardFilm.checkRollUpDescription();
        cardFilm.clickToLikeButton();
        cardFilm.clickToDisLikeButton();
        pageCMS.deleteAccountMF("79260192144");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}

