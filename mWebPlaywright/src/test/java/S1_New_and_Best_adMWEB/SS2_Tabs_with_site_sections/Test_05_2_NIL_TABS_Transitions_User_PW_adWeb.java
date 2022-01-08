package S1_New_and_Best_adMWEB.SS2_Tabs_with_site_sections;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_05_2_NIL_TABS_Transitions_User_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "5. BANNER_ZONE_Transitions_User")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void BANNER_ZONE_Transitions_User() throws IOException, InterruptedException {
         // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.clickToButtonTrailerFilmOnBanner();
        cardFilmPW.checkStartTrailerPlayer(); // баг: нет автозапуска трейлера при переходе из баннера НиЛ
        headerMenuPW.goToNilPage();
        nilPagePW.clickToButtonTrailerSerialOnBanner();
        cardSerialPW.checkStartTrailerPlayer();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToButtonTrailerTvProgramOnBanner(); // баг: неверная ссылка тв передачи в баннере НиЛ
        headerMenuPW.goToNilPage();
        nilPagePW.clickToButtonTrailerTvChannelOnBanner();
        // click to banner:
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnBannerFilm(); // баг: нет перехода в карточку контента по клику на баннер
        cardFilmPW.checkStartTrailerPlayer();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnBannerSerial(); // баг: нет перехода в карточку контента по клику на баннер
        cardSerialPW.checkStartTrailerPlayer();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnBannerTvProgram(); // баг: нет перехода в карточку контента по клику на баннер
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnBannerTvChannel(); // баг: нет перехода в карточку контента по клику на баннер
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.tapOnProfileNonAdWeb();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdMWeb("+7 926 019 21 44");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPageCreatePasswordAdMWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdMWeb("79260192144");
        headerMenuPW.tapToComeInNonAdMWeb("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
