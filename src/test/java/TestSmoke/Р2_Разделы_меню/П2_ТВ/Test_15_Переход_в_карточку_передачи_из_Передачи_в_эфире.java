package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_15_Переход_в_карточку_передачи_из_Передачи_в_эфире extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Переход в карточку передачи из Передачи в эфире")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void openCardTvProgramFromTabAir() {
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.clickToTailTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
        pageCMS.deleteAccountMF();
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenFrameInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenFrameCreatePassword("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrect();
    }
}
