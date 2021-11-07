package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_ADWEB.SSS3_Banner_zone;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_05_1_NIL_BANNER_ZONE_Transitions_Guest_PW_bugs_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "5. BANNER_ZONE_Transitions_Guest")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void BANNER_ZONE_Transitions_Guest() throws IOException, InterruptedException {
        // Guest:
        // click to button trailer:
        headerMenuPW.goToNilPage();
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
}
