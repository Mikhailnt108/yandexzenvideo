package TestSmokeWeb.Р2_Разделы_меню_ТВ.П1_ТВ_FRESH;

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
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_05_1_Карточка_передачи_RETEST2408 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value ="5.1 Карточка передачи")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void cardTvProgram() throws Exception {
        //неавторизованный пользователь:
        headerMenu.goToTvPage();
        tvPage.clickOnTabTvProgramInAir();
        tvPage.clickOnTabInRecording();
        tvPage.clickToTailTvProgram();
        cardTvProgram.checkOpenCardTvProgram();
        cardTvProgram.checkElementsInCardTvProgram();
        //авторизованный пользователь:
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.clickOnTabInRecording();
        tvPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        cardTvChannel.clickPaymentButtonInCardTvChannel();
        cardTvChannel.checkPaymentComplete();
        cardTvChannel.clickOnTvProgramInCardChannel();
        cardTvProgram.checkOpenCardTvProgram();
        cardTvProgram.checkAutoStartVideoPlayer();
        cardTvProgram.checkButtonFavoriteNotAdded();
        cardTvProgram.clickButtonFavorite();
        cardTvProgram.checkButtonFavoriteAdded();
        cardTvProgram.clickOnTvChannelInCardProgram();
        cardTvChannel.checkOpenCardTvChannel();
        pageCMS.deleteAccountMF("79260192144");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260192144");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260192144", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260192144");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
