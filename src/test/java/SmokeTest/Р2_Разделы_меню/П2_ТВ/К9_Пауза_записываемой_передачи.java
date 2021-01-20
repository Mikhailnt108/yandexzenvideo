package SmokeTest.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class К9_Пауза_записываемой_передачи extends TestBase {
    //DSoUWlplI4m8T5WSf-XxC
    @Test
    public void pauseTvProgramInRecording() throws Exception {
        headerMenu.goToTvPage();
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameInputPassword();
        headerMenu.inputPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabInRecording();
        tvPage.checkСhannelsСorrespondGenres();
        cardTvProgram.clickOnLinkTvProgramInRecording();
        //cardTvProgram.clickToPauseVideoPleer();
        //cardTvProgram.clickToPlayVideoPleer();
        //cardTvProgram.clickToSpaceToVideoPleer();
        cardTvProgram.clickToLeftButtonMouseToVideoPleer();


    }
}
