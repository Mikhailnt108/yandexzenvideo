package Smoke.Р2_Разделы_меню.П2_ТВ;

import Smoke.TestBase;
import org.junit.jupiter.api.Test;

public class К10_Перемотка_записанной_передачи extends TestBase {
    @Test
    public void rewindTvProgram() throws Exception {
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
        cardTvProgram.moveSliderRewindToVideoPleer();
    }
}
