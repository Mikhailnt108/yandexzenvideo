package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К9_Пауза_записываемой_передачи extends TestBase {
    //DSoUWlplI4m8T5WSf-XxC
    @Test
    public void pauseTvProgramInRecording() throws Exception {
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabInRecording();
        tvPage.checkСhannelsСorrespondGenres();
        cardTvProgram.clickOnLinkTvProgramInRecording();
        cardTvProgram.clickPaymentButtonInCardTvProgram();
        cardTvProgram.checkPaymentComplete();
        cardTvProgram.clickToButtonPlay();
        cardTvProgram.clickToPauseVideoPleer();
        cardTvProgram.clickToPlayVideoPleer();
        cardTvProgram.clickToSpaceToVideoPleer();
        cardTvProgram.clickToLeftButtonMouseToVideoPleer();
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
