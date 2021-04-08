package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_08_Просмотр_передачи extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Просмотр передачи")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void viewingTvProgram() throws Exception {
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.clickToTailTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
        cardTvProgram.clickPaymentButtonInCardTvProgram();
        cardTvProgram.checkPaymentComplete();
        cardTvProgram.clickToButtonPlay();
        cardTvProgram.startVideoPlayer();
        pageCMS.deleteAccountMF();
    }
    private void flowRegistation() {
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
