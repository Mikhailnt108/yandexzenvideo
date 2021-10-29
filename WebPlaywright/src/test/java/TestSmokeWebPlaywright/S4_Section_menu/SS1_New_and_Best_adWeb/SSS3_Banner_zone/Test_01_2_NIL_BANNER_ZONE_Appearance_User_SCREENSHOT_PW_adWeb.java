package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS3_Banner_zone;

import base.TestBasePlaywright;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Mouse.DownOptions;
import com.microsoft.playwright.options.MouseButton;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

public class Test_01_2_NIL_BANNER_ZONE_Appearance_User_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "1.2 NIL_BANNER_ZONE_Appearance_User_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_BANNER_ZONE_Appearance_User_SCREENSHOT() throws IOException, InterruptedException, AWTException {
    // User:
    // min:
        headerMenuPW.goToNilPage();
        flowRegistation();
        headerMenuPW.openMinFramePage();
        nilPagePW.checkElementsBannerMinPageNilUser();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkImageBannerMinPageNilUser();
    // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsBannerMediumPageNilUser();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkImageBannerMediumPageNilUser();
    // wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsBannerWidePageNilUser();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkImageBannerWidePageNilUser();
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
