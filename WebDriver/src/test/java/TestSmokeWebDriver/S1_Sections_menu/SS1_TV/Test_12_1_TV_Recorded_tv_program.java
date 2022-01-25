package TestSmokeWebDriver.S1_Sections_menu.SS1_TV;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#0", mode = ResourceAccessMode.READ_WRITE)
public class Test_12_1_TV_Recorded_tv_program extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Sections_menu")
    @Story(value = "1. TV")
    @DisplayName(value ="Recorded_tv_program")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#0")
    public void recordedTvProgram() throws Exception {
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.clickOnTabInRecording();
        tvPage.clickToTailTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
        cardTvProgram.clickOnLinkTvProgramInRecording();
        cardTvProgram.clickPaymentButtonInCardTvProgram();
        cardTvProgram.checkPaymentComplete();
        headerMenu.refreshPage();
        cardTvProgram.checkAutoStartVideoPlayer();
        cardTvProgram.checkElementsPlayerRecordedTvProgram();
        cardTvProgram.testFullScreenPlayer();
        cardTvProgram.testOnAndOffAudioInPlayer();
        cardTvProgram.clickOnScheduleInPlayerInRecordedAndCheckeElements();
        cardTvProgram.switchOtherTvProgramInsidePleerSchedule();
        headerMenu.refreshPage();
        cardTvProgram.clickToPauseVideoPleer();
        cardTvProgram.clickToPlayVideoPleer();
        cardTvProgram.rewindOn10secondsToVideoPleer();
//        cardTvProgram.swithOtherTvProgramInsidePlayerCarousel();
//        cardTvProgram.clickOnLinkNextTvProgramInRecording();
//        cardTvProgram.swithOtherTvChannelInsidePlayerForRecording();
//        cardTvProgram.checkAutoStartVideoPlayer();
        pageCMS.deleteAccountMF("79250110212");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9250110212");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9250110212", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79250110212");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
