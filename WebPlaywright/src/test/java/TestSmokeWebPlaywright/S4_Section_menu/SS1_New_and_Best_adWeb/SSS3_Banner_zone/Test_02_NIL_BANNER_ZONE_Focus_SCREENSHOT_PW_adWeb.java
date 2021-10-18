package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS3_Banner_zone;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class Test_02_NIL_BANNER_ZONE_Focus_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "2. BANNER_ZONE_Focus_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void BANNER_ZONE_Focus() throws IOException, InterruptedException {
        // Guest:
        nilPagePW.checkHoverTrailerImageGuest();
        nilPagePW.checkHoverFavoriteImageGuest();
        nilPagePW.checkHoverBlockArrowNextImageGuest();
        nilPagePW.checkHoverBlockArrowPreviousImageGuest();

        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        nilPagePW.checkHoverTrailerImageUser();
        nilPagePW.checkHoverFavoriteImageUser();
        nilPagePW.checkHoverBlockArrowNextImageUser();
        nilPagePW.checkHoverBlockArrowPreviousImageUser();
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
    private void flowAutorization() {
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.inputPasswordAutorization("111111");
        headerMenuPW.clickToComeIn("Войти");
    }
}
