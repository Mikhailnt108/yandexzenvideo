package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS4_Footer;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;
import java.sql.SQLException;

@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_NIL_FOOTER_Focus_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "2. FOOTER_Focus")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("53962590")
    @Test
    @Tag("adWebSuitePW#1")
    public void FOOTER_Focus() throws IOException, InterruptedException, SQLException {
        // Guest:
        headerMenuPW.goToNilPage();
        nilPagePW.hoverOnListBlockDevicesFooterAndCheckColor();
        nilPagePW.hoverOnListBlockSupportFooterAndCheckColor();
        nilPagePW.checkImageBlockSocialLinkInFooterGuest();
        nilPagePW.checkImageBlockDownloadsInFooterGuest();
        nilPagePW.hoverOnListBlockDocsFooterAndCheckColor();
        // User:
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        nilPagePW.waitHiddenMessageContentIsBeingLoaded();
        nilPagePW.hoverOnListBlockDevicesFooterAndCheckColor();
        nilPagePW.hoverOnListBlockSupportFooterAndCheckColor();
        nilPagePW.checkImageBlockSocialLinkInFooterUser();
        nilPagePW.checkImageBlockDownloadsInFooterUser();
        nilPagePW.hoverOnListBlockDocsFooterAndCheckColor();
    }
    private void flowRegistationMF() throws SQLException {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginAdWeb("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForAdWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.inputCodeMsisdnFromDB("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
