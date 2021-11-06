package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS3_Banner_zone;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

public class Test_01_1_NIL_BANNER_ZONE_Appearance_Guest_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "1.1 NIL_BANNER_ZONE_Appearance_Guest_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("CheckWithRobot")
    public void NIL_BANNER_ZONE_Appearance_Guest_SCREENSHOT() throws IOException, InterruptedException, AWTException {
        // Guest:
        // min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsBannerMinPageNilGuest();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkImageBannerMinPageNilGuest();
        // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsBannerMediumPageNilGuest();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkImageBannerMediumPageNilGuest();
        // wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsBannerWidePageNilGuest();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkImageBannerWidePageNilGuest();
    }
}
