package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS2_Banner_zone;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Test_03_BANNER_ZONE_Navigation_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "3. BANNER_ZONE_Navigation")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void BANNER_ZONE_Navigation() {
        // Guest:
        headerMenuPW.goToNilPage();
        niLPagePW.checkScrollBannersToRight();
        niLPagePW.checkScrollBannersToLeft();
        niLPagePW.checkScrollLastBannerToRight();
        niLPagePW.checkScrollFirstBannerToLeft();

        // User:
        headerMenuPW.goToNilPage();
        flowRegistation();
        niLPagePW.checkScrollBannersToRight();
        niLPagePW.checkScrollBannersToLeft();
        niLPagePW.checkScrollLastBannerToRight();
        niLPagePW.checkScrollFirstBannerToLeft();
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
