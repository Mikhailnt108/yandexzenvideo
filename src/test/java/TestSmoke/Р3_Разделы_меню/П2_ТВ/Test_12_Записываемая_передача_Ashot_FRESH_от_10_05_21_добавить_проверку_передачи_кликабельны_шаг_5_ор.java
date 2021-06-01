package TestSmoke.Р3_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_12_Записываемая_передача_Ashot_FRESH_от_10_05_21_добавить_проверку_передачи_кликабельны_шаг_5_ор extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Записываемая ТВ передача")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
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
//        cardTvProgram.checkImageDifferVideoPlayerRecordedAndSchedule();
        cardTvProgram.checkElementsPlayerRecordedTvProgram();
        cardTvProgram.testFullScreenPlayer();
        cardTvProgram.testOnAndOffAudioInPlayer();
        cardTvProgram.clickOnScheduleInPlayerInRecordedAndCheckeElements();
        headerMenu.refreshPage();
        cardTvProgram.clickToPauseVideoPleer();
        cardTvProgram.clickToPlayVideoPleer();
        cardTvProgram.rewindOn10secondsToVideoPleer();
        cardTvProgram.swithOtherTvProgramInsidePlayer();
        cardTvProgram.clickOnLinkNextTvProgramInRecording();
        cardTvProgram.swithOtherTvChannelInsidePlayer();
        cardTvProgram.checkAutoStartVideoPlayer();
        pageCMS.deleteAccountMF("79260192144");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
