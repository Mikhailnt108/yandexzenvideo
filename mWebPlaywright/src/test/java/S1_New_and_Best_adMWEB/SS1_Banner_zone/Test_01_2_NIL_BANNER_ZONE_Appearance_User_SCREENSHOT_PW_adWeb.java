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
public class Test_01_2_NIL_BANNER_ZONE_Appearance_User_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1.2 NIL_BANNER_ZONE_Appearance_User_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_BANNER_ZONE_Appearance_User_SCREENSHOT() throws IOException, InterruptedException, AWTException {
    // User:
    // aphone:
        headerMenuPW.goToNilPage();
        flowRegistation();
        headerMenuPW.openAphoneFramePage();
        nilPagePW.checkElementsBannerMinPageNilUser();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkImageBannerMinPageNilUser();
    // apad:
        headerMenuPW.openApadFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsBannerMediumPageNilUser();
        headerMenuPW.stopCarouselBanners();
        nilPagePW.checkImageBannerMediumPageNilUser();
    // wide:
//        headerMenuPW.openWideFramePage();
//        headerMenuPW.goToNilPage();
//        nilPagePW.checkElementsBannerWidePageNilUser();
//        headerMenuPW.stopCarouselBanners();
//        nilPagePW.checkImageBannerWidePageNilUser();
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