package S1_New_and_Best_adMWEB.SSS4_Footer;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_NIL_FOOTER_Focus_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "2. FOOTER_Focus")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void FOOTER_Focus() throws IOException, InterruptedException {
        // Guest:
        headerMenuPW.goToNilPage();
        nilPagePW.hoverOnListBlockDevicesFooterAndCheckColor();
        nilPagePW.hoverOnListBlockSupportFooterAndCheckColor();
        nilPagePW.checkImageBlockSocialLinkInFooterGuestMWEB();
        nilPagePW.checkImageBlockDownloadsInFooterGuestMWEB();
        nilPagePW.hoverOnListBlockDocsFooterAndCheckColor();
        // User:
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        nilPagePW.waitHiddenMessageContentIsBeingLoaded();
        nilPagePW.hoverOnListBlockDevicesFooterAndCheckColor();
        nilPagePW.hoverOnListBlockSupportFooterAndCheckColor();
        nilPagePW.checkImageBlockSocialLinkInFooterUserMWEB();
        nilPagePW.checkImageBlockDownloadsInFooterUserMWEB();
        nilPagePW.hoverOnListBlockDocsFooterAndCheckColor();
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.tapOnProfileNonAdWeb();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdMWeb("+7 926 019 21 44");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPageCreatePasswordAdMWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdMWeb("79260192144");
        headerMenuPW.tapToComeInNonAdMWeb("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
