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
public class Test_01_NIL_FOOTER_Appearance_SCREENSHOT_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "1. FOOTER_Appearance")
    @Severity(SeverityLevel.BLOCKER)
//    @TmsLink("53962589")
    @Test
    @Tag("adWebSuitePW#1")
    public void FOOTER_Appearance() throws IOException, InterruptedException, SQLException {
        // Guest:
        // min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsFooterMinPage();
        nilPagePW.checkImageFooterMinPageGuest();
        nilPagePW.checkImageOpenListsDevicesFooterMinPageGuest();
        nilPagePW.checkImageOpenListsSupportFooterMinPageGuest();
        // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsFooterMediumPage();
        nilPagePW.checkImageFooterMediumPageGuest();
        nilPagePW.checkImageOpenListsDevicesFooterMediumPageGuest();
        nilPagePW.checkImageOpenListsSupportFooterMediumPageGuest();
        // wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.checkElementsFooterWidePage();
        nilPagePW.checkImageFooterWidePageGuest();
        // User:
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        // min:
        headerMenuPW.openMinFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.waitHiddenMessageContentIsBeingLoaded();
        nilPagePW.checkElementsFooterMinPage();
        nilPagePW.checkImageFooterMinPageUser();
        nilPagePW.checkImageOpenListsDevicesFooterMinPageUser();
        nilPagePW.checkImageOpenListsSupportFooterMinPageUser();
        // medium:
        headerMenuPW.openMediumFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.waitHiddenMessageContentIsBeingLoaded();
        nilPagePW.checkElementsFooterMediumPage();
        nilPagePW.checkImageFooterMediumPageUser();
        nilPagePW.checkImageOpenListsDevicesFooterMediumPageUser();
        nilPagePW.checkImageOpenListsSupportFooterMediumPageUser();
        // wide:
        headerMenuPW.openWideFramePage();
        headerMenuPW.goToNilPage();
        nilPagePW.waitHiddenMessageContentIsBeingLoaded();
        nilPagePW.checkElementsFooterWidePage();
        nilPagePW.checkImageFooterWidePageUser();
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
