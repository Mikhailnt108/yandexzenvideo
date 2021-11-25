package S1_Section_menu.SS3_Films;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuitePwNonAdWeb#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_2_FILMS_Appearance_card_SCREENSHOT_TRAILER_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "3. Films")
    @DisplayName(value ="03_2_FILMS_Appearance_card_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void FILMS_Appearance_card_SCREENSHOT_TRAILER() throws Exception {
        headerMenuPW.goToFilmsPage();
        filmsPagePW.clickToTailCardFilm();
        cardFilmPW.checkStartTrailerPlayer();
        cardFilmPW.checkImageCardFilmForGuest();
        headerMenuPW.goToFilmsPage();
        flowRegistationMF();
        headerMenuPW.goToFilmsPage();
        filmsPagePW.clickToTailCardFilm();
        cardFilmPW.paymentRent2ForFilm();
        cardFilmPW.checkStartTrailerPlayer();
        cardFilmPW.checkImageCardFilmForUser();
        headerMenuPW.deleteAccountMF("79260205027");
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginNonAdWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForNonAdWeb("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}

