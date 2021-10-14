package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS2_Banner_zone;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_04_BANNER_ZONE_Adding_to_Favorites_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "4. BANNER_ZONE_Adding_to_Favorites")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void BANNER_ZONE_Adding_to_Favorites() throws IOException, InterruptedException {
        // Guest:
        headerMenuPW.goToNilPage();
        niLPagePW.clickToFavoriteFilmOnBannerGuest();
        headerMenuPW.goToNilPage();
        niLPagePW.clickToFavoriteSerialOnBannerGuest();
        headerMenuPW.goToNilPage();
        niLPagePW.checkClickToFavoriteTvProgramOnBannerGuest();
        headerMenuPW.goToNilPage();
        niLPagePW.clickToFavoriteTvChannelOnBannerGuest();

        // User:
        // добавление в избранное:
        headerMenuPW.goToNilPage();
        flowRegistation();
        niLPagePW.checkAddToFavoriteFilmFromBannerUser();
        headerMenuPW.goToNilPage();
        niLPagePW.checkAddToFavoriteSerialFromBannerUser();
        headerMenuPW.goToNilPage();
        niLPagePW.checkAddToFavoriteTvProgramFromBannerUser();
        headerMenuPW.goToNilPage();
        niLPagePW.checkAddToFavoriteTvChannelFromBannerUser();

        // удаление из избранного:
        headerMenuPW.goToNilPage();
        niLPagePW.checkRemoveToFavoriteFilmFromBannerUser();
        headerMenuPW.goToNilPage();
        niLPagePW.checkRemoveToFavoriteSerialFromBannerUser();
        headerMenuPW.goToNilPage();
        niLPagePW.checkRemoveToFavoriteTvProgramFromBannerUser();
        headerMenuPW.goToNilPage();
        niLPagePW.checkRemoveToFavoriteTvChannelFromBannerUser();
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
