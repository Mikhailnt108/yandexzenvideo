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
public class Test_11_1_TV_Unrecorded_tv_program extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Sections_menu")
    @Story(value = "1. TV")
    @DisplayName(value ="Unrecorded_tv_program")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#0")
    public void unrecordedTvProgram() throws Exception {
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.clickToTailTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
        cardTvProgram.clickPaymentButtonInCardTvProgram();
        cardTvProgram.checkPaymentComplete();
        headerMenu.refreshPage();
        cardTvProgram.checkAutoStartVideoPlayer();
        headerMenu.refreshPage();
        cardTvProgram.checkElementsPlayerUnrecordedTvProgram();
        cardTvProgram.testFullScreenPlayer();
        cardTvProgram.testOnAndOffAudioInPlayer();
        cardTvProgram.clickOnScheduleInPlayerUnrecordedAndCheckeElements();
//        headerMenu.refreshPage();
//        cardTvProgram.swithOtherTvChannelInsidePlayerForUnrecorded();
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
