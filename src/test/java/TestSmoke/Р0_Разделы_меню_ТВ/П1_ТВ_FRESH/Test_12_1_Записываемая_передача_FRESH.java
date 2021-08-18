package TestSmoke.Р0_Разделы_меню_ТВ.П1_ТВ_FRESH;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_12_1_Записываемая_передача_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
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
        cardTvProgram.checkElementsPlayerRecordedTvProgram();
        cardTvProgram.testFullScreenPlayer();
        cardTvProgram.testOnAndOffAudioInPlayer();
        cardTvProgram.clickOnScheduleInPlayerInRecordedAndCheckeElements();
        cardTvProgram.switchOtherTvProgramInsidePleerSchedule();
        headerMenu.refreshPage();
        cardTvProgram.clickToPauseVideoPleer();
        cardTvProgram.clickToPlayVideoPleer();
        cardTvProgram.rewindOn10secondsToVideoPleer();
        cardTvProgram.swithOtherTvProgramInsidePlayerCarousel();
        cardTvProgram.clickOnLinkNextTvProgramInRecording();
        cardTvProgram.swithOtherTvChannelInsidePlayerForRecording();
        cardTvProgram.checkAutoStartVideoPlayer();
        pageCMS.deleteAccountMF("79260205027");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260205027");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260205027", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260205027");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
