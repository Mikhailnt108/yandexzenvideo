package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS4_Footer;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_03_NIL_FOOTER_Transitions_SCREENSHOT_bug_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "3. FOOTER_Transitions")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void FOOTER_Transitions() throws IOException, InterruptedException {
        // Guest:
        headerMenuPW.goToNilPage();
        nilPagePW.goToLinksBlockDevicesFooter();
        nilPagePW.goToLinksBlockSupportFooter();
        nilPagePW.goToLinkBlockSocialNetworksFooter();
        nilPagePW.goToLinkBlockStoresFooter();
        nilPagePW.goToLinksBlockDocumentsFooter();
        nilPagePW.clickToButtonSpeedtestInFooter();
        // User:
        flowRegistationMF();
        headerMenuPW.goToNilPage();
        nilPagePW.goToLinksBlockDevicesFooter();
        nilPagePW.goToLinksBlockSupportFooter();
        nilPagePW.goToLinkBlockSocialNetworksFooter();
        nilPagePW.goToLinkBlockStoresFooter();
        nilPagePW.goToLinksBlockDocumentsFooter();
        nilPagePW.clickToButtonSpeedtestInFooter();
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
