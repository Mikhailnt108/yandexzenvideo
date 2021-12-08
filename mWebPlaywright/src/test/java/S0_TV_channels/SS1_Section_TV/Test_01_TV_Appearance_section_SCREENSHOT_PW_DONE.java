package S0_TV_channels.SS1_Section_TV;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "AndroidWebPW#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_TV_Appearance_section_SCREENSHOT_PW_DONE extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "0. TV_channels")
    @Story(value = "1. Section_TV")
    @DisplayName(value = "TV_Appearance_section_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("AndroidWebPW#1")
    public void TV_Appearance_section_SCREENSHOT() throws Exception {
        headerMenuPW.goToTabTv();
        tvPagePW.checkElementsTvPageGuest();
        tvPagePW.scrollDownPageAndCheckFooter();
//        tvPagePW.checkImageTvPageForGuestMWEB();
//        tvPagePW.checkImageFooterMWEB();
        flowRegistationMF();
        headerMenuPW.goToTabTv();
        tvPagePW.checkElementsTvPageUser();
        tvPagePW.scrollDownPageAndCheckFooter();
//        tvPagePW.checkImageTvPageForUserMWEB();
//        tvPagePW.checkImageFooterMWEB();
    }
    private void flowRegistationMF() throws InterruptedException {
        headerMenuPW.clickToProfile();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginNonAdmWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForNonAdWeb("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}
