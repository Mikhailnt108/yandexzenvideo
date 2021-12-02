package S1_New_and_Best_adMWEB.SS1_Banner_zone;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.awt.*;
import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_NIL_BANNER_ZONE_Adding_to_Favorites_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "4. BANNER_ZONE_Adding_to_Favorites")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void BANNER_ZONE_Adding_to_Favorites() throws IOException, InterruptedException, AWTException {
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
        nilPagePW.checkImageAddToFavoriteFilmFromBannerUserMWEB();
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
        headerMenuPW.clickToProfile();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdmWeb("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForAdWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdWeb("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
