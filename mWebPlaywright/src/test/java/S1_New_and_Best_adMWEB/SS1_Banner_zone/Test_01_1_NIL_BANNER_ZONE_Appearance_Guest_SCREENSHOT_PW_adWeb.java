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
public class Test_01_1_NIL_BANNER_ZONE_Appearance_Guest_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1.1 NIL_BANNER_ZONE_Appearance_Guest_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_BANNER_ZONE_Appearance_Guest_SCREENSHOT() throws IOException, InterruptedException, AWTException {
        // Guest:
        // aphone:
        headerMenuPW.openAphoneFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsBannerAphonePageNilGuest();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkImageBannerAphonePageNilGuestMWEB();
        // apad:
        headerMenuPW.openApadFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsBannerApadPageNilGuestMWEB();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkImageBannerApadPageNilGuestMWEB();
//        // wide:
//        headerMenuPW.openWideFramePage();
//        headerMenuPW.goToNilPage();
//        nilPagePW.checkElementsBannerWidePageNilGuest();
//        headerMenuPW.stopCarouselBanners();
//        nilPagePW.checkImageBannerWidePageNilGuest();
    }
}
