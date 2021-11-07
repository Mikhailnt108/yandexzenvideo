package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS3_Banner_zone;

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
public class Test_02_NIL_BANNER_ZONE_Focus_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "2. BANNER_ZONE_Focus_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void BANNER_ZONE_Focus() throws IOException, InterruptedException, AWTException {
        // Guest:
        headerMenuPW.goToNilPage();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkHoverTrailerImageGuest();
        nilPagePW.checkHoverFavoriteImageGuest();
        nilPagePW.checkHoverBlockArrowNextImageGuest();
        nilPagePW.checkHoverBlockArrowPreviousImageGuest();

        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkHoverTrailerImageUser();
        nilPagePW.checkHoverFavoriteImageUser();
        nilPagePW.checkHoverBlockArrowNextImageUser();
        nilPagePW.checkHoverBlockArrowPreviousImageUser();
    }
    private void flowRegistation() {
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
    }
}
