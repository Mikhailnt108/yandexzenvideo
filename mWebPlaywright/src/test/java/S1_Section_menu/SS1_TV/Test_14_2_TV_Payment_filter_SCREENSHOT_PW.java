package S1_Section_menu.SS1_TV;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "AndroidWebPW#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_14_2_TV_Payment_filter_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Mobile Android Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "1. TV")
    @DisplayName(value = "TV_Payment_filter_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("AndroidWebPW#0")
    public void tv_Payment_filter_SCREENSHOT() throws InterruptedException, IOException {
        headerMenuPW.goToTabTv();
        flowRegistationMF();
        tvPagePW.checkImageTvPageTabProgramTvForAuthorizedMWEB();
        headerMenuPW.deleteAccountMF("79260205027");
    }

    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToProfile();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdmWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdWeb("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}
