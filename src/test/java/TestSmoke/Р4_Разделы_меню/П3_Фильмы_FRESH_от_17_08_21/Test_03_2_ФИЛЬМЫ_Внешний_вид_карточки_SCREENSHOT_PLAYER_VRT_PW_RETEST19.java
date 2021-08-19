package TestSmoke.Р4_Разделы_меню.П3_Фильмы_FRESH_от_17_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_03_2_ФИЛЬМЫ_Внешний_вид_карточки_SCREENSHOT_PLAYER_VRT_PW_RETEST19 extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "3. Фильмы")
    @DisplayName(value ="3.2 Внешний вид карточки (скриншоты")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearanceSectionCardFilm() throws Exception {
        headerMenuPW.goToFilmsPage();
        filmsPagePW.clickToTailCardFilm();
        cardFilmPW.checkStartTrailerPlayer();
        cardFilmPW.checkImageCardFilmForGuest();
        flowRegistation();
        cardFilmPW.paymentRent2ForFilm();
        cardFilmPW.checkStartTrailerPlayer();
        cardFilmPW.checkImageCardFilmForUser();
        headerMenuPW.deleteAccountMF("79260192144");
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}

