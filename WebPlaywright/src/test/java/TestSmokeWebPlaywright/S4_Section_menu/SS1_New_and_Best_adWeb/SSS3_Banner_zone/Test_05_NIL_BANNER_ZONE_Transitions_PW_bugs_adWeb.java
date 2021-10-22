package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS3_Banner_zone;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_05_NIL_BANNER_ZONE_Transitions_PW_bugs_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "5. BANNER_ZONE_Transitions")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void BANNER_ZONE_Transitions() throws IOException, InterruptedException {
        // Guest:
        // click to button trailer:
        headerMenuPW.goToNilPage();
        nilPagePW.clickToButtonTrailerFilmOnBanner();
        cardFilmPW.checkStartTrailerPlayer(); // баг: нет автозапуска трейлера при переходе из баннера НиЛ
        headerMenuPW.goToNilPage();
        nilPagePW.clickToButtonTrailerSerialOnBanner();
        cardSerialPW.checkStartTrailerPlayer();
        headerMenuPW.goToNilPage();
//        niLPagePW.clickToButtonTrailerTvProgramOnBanner(); // баг: неверная ссылка тв передачи в баннере НиЛ
        headerMenuPW.goToNilPage();
        nilPagePW.clickToButtonTrailerTvChannelOnBanner();
        // click to banner:
        headerMenuPW.goToNilPage();
//        niLPagePW.clickOnBannerFilm(); // баг: нет перехода в карточку контента по клику на баннер
//        cardFilmPW.checkStartTrailerPlayer();
        headerMenuPW.goToNilPage();
//        niLPagePW.clickOnBannerSerial(); // баг: нет перехода в карточку контента по клику на баннер
//        cardSerialPW.checkStartTrailerPlayer();
        headerMenuPW.goToNilPage();
//        niLPagePW.clickOnBannerTvProgram(); // баг: нет перехода в карточку контента по клику на баннер
        headerMenuPW.goToNilPage();
//        niLPagePW.clickOnBannerTvChannel(); // баг: нет перехода в карточку контента по клику на баннер
        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.clickToButtonTrailerFilmOnBanner();
//        cardFilmPW.checkStartTrailerPlayer(); // баг: нет автозапуска трейлера при переходе из баннера НиЛ
        headerMenuPW.goToNilPage();
        nilPagePW.clickToButtonTrailerSerialOnBanner();
        cardSerialPW.checkStartTrailerPlayer();
        headerMenuPW.goToNilPage();
//        niLPagePW.clickToButtonTrailerTvProgramOnBanner(); // баг: неверная ссылка тв передачи в баннере НиЛ
        headerMenuPW.goToNilPage();
        nilPagePW.clickToButtonTrailerTvChannelOnBanner();
        // click to banner:
        headerMenuPW.goToNilPage();
//        niLPagePW.clickOnBannerFilm(); // баг: нет перехода в карточку контента по клику на баннер
//        cardFilmPW.checkStartTrailerPlayer();
        headerMenuPW.goToNilPage();
//        niLPagePW.clickOnBannerSerial(); // баг: нет перехода в карточку контента по клику на баннер
//        cardSerialPW.checkStartTrailerPlayer();
        headerMenuPW.goToNilPage();
//        niLPagePW.clickOnBannerTvProgram(); // баг: нет перехода в карточку контента по клику на баннер
        headerMenuPW.goToNilPage();
//        niLPagePW.clickOnBannerTvChannel(); // баг: нет перехода в карточку контента по клику на баннер
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
