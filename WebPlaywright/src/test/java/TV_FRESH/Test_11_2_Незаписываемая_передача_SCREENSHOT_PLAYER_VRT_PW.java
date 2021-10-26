package TV_FRESH;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuitePW", mode = ResourceAccessMode.READ_WRITE)
public class Test_11_2_Незаписываемая_передача_SCREENSHOT_PLAYER_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value ="Незаписываемая ТВ передача (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void unrecordedTvProgram() throws Exception {
        headerMenuPW.goToTvTabTvProgramInAir();
        flowRegistationMF();
        headerMenuPW.saveCookiesBrowserHeadless();
        headerMenuPW.getCookiesAndOpenHeadfullBrowser();
        headerMenuPW.goToTvTabTvProgramInAirHeadfull();
        cardTvProgramPW.chooseTailTvProgramTabAll();
        cardTvProgramPW.checkAutoStartVideoPlayer();
        cardTvProgramPW.checkImagePlayerСardTvProgramUnrecordedUser();
        cardTvProgramPW.checkImageScheduleСardTvProgramUnrecorded();
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
