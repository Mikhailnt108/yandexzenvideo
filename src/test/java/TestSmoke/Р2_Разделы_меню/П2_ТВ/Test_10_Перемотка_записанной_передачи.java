package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;

public class Test_10_Перемотка_записанной_передачи extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "10. Перемотка записанной передачи")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void rewindTvProgram() throws Exception {
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabInRecording();
        tvPage.checkСhannelsСorrespondGenres();
        cardTvProgram.clickOnLinkTvProgramInRecording();
        cardTvProgram.clickPaymentButtonInCardTvProgram();
        cardTvProgram.checkPaymentComplete();
        cardTvProgram.clickToButtonPlay();
        cardTvProgram.moveSliderRewindToVideoPleer();
        pageCMS.deleteAccount();
    }

    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenFrameInputCod();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
