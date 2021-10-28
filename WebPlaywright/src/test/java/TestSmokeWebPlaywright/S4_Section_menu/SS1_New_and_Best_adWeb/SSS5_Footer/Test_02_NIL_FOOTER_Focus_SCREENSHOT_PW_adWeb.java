package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS5_Footer;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_02_NIL_FOOTER_Focus_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "2. FOOTER_Focus")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void FOOTER_Focus() throws IOException, InterruptedException {
        // Guest:
//        headerMenuPW.goToNilPage();
//        nilPagePW.hoverOnListBlockDevicesFooterAndCheckColor();
//        nilPagePW.hoverOnListBlockSupportFooterAndCheckColor();
//        nilPagePW.checkImageBlockSocialLinkInFooterGuest();
//        nilPagePW.checkImageBlockDownloadsInFooterGuest();
//        nilPagePW.hoverOnListBlockDocsFooterAndCheckColor();
        // User:
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        nilPagePW.waitHiddenMessageSelectContentForYou();
        nilPagePW.hoverOnListBlockDevicesFooterAndCheckColor();
        nilPagePW.hoverOnListBlockSupportFooterAndCheckColor();
        nilPagePW.checkImageBlockSocialLinkInFooterUser();
        nilPagePW.checkImageBlockDownloadsInFooterUser();
        nilPagePW.hoverOnListBlockDocsFooterAndCheckColor();
    }
    private void flowRegistationMF() {
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
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
