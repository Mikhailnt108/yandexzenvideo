package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS3_Banner_zone;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_04_NIL_BANNER_ZONE_Adding_to_Favorites_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
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
        nilPagePW.clickToFavoriteFilmOnBannerGuest();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToFavoriteSerialOnBannerGuest();
        headerMenuPW.goToNilPage();
        nilPagePW.checkClickToFavoriteTvProgramOnBannerGuest();
        headerMenuPW.goToNilPage();
        nilPagePW.clickToFavoriteTvChannelOnBannerGuest();

        // User:
        // добавление в избранное:
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.checkAddToFavoriteFilmFromBannerUser();
        headerMenuPW.goToNilPage();
        nilPagePW.checkAddToFavoriteSerialFromBannerUser();
        headerMenuPW.goToNilPage();
        nilPagePW.checkAddToFavoriteTvProgramFromBannerUser();
        headerMenuPW.goToNilPage();
        nilPagePW.checkAddToFavoriteTvChannelFromBannerUser();

        // удаление из избранного:
        headerMenuPW.goToNilPage();
        nilPagePW.checkRemoveToFavoriteFilmFromBannerUser();
        headerMenuPW.goToNilPage();
        nilPagePW.checkRemoveToFavoriteSerialFromBannerUser();
        headerMenuPW.goToNilPage();
        nilPagePW.checkRemoveToFavoriteTvProgramFromBannerUser();
        headerMenuPW.goToNilPage();
        nilPagePW.checkRemoveToFavoriteTvChannelFromBannerUser();
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
