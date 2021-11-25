package TestsPlayer;

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
public class Test_12_2_Recorded_Tv_program_SCREENSHOT_PLAYER_Bug_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "2. TV")
    @DisplayName(value ="12_2_Recorded_Tv_program_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void Recorded_Tv_program_SCREENSHOT_PLAYER() throws Exception {
        headerMenuPW.goToTvTabTvProgramInAir();
        flowRegistationMF();
        headerMenuPW.saveCookiesBrowserHeadless();
        headerMenuPW.getCookiesAndOpenHeadfullBrowser();
        headerMenuPW.goToTvTabTvProgramInAirHeadfull();
        cardTvProgramPW.chooseTailTvProgramTabInRecorder();
        cardTvProgramPW.subscribeToPackageTvProgram();
        cardTvProgramPW.clickOnRecordedTvProgramTwoDaysAgo();
        cardTvProgramPW.checkAutoStartVideoPlayer();
        cardTvProgramPW.checkImagePlayerСardTvProgramRecordedUser();
        cardTvProgramPW.checkImageScheduleСardTvProgramRecorded();
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
