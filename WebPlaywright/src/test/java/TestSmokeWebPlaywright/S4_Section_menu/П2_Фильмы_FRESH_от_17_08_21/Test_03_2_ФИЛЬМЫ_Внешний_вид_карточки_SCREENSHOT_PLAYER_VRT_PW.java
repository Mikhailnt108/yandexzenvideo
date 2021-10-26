package TestSmokeWebPlaywright.S4_Section_menu.П2_Фильмы_FRESH_от_17_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_2_ФИЛЬМЫ_Внешний_вид_карточки_SCREENSHOT_PLAYER_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="3.2 Внешний вид карточки (скриншоты")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void appearanceSectionCardFilm() throws Exception {
        headerMenuPW.goToFilmsPage();
        filmsPagePW.clickToTailCardFilm();
        cardFilmPW.checkStartTrailerPlayer();
        cardFilmPW.checkImageCardFilmForGuest();
        flowRegistationMF();
        cardFilmPW.paymentRent2ForFilm();
        cardFilmPW.checkStartTrailerPlayer();
        cardFilmPW.checkImageCardFilmForUser();
        headerMenuPW.deleteAccountMF("79260192144");
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}

