package TestSmoke.Р3_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_05_Карточка_передачи_Ashot_FRESH_от_05_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Карточка передачи")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void cardTvProgram() throws Exception {
        //неавторизованный пользователь:
        headerMenu.goToTvPage();
        tvPage.checkOpenTvPageTabScheduleTv();
        tvPage.clickOnTabInRecording();
        tvPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        cardTvChannel.clickOnTvProgramInCardChannel();
        cardTvProgram.checkOpenCardTvProgram();
        cardTvProgram.checkElementsInCardTvProgram();
//        cardTvProgram.checkImageDifferCardTvProgramForUnauthorized();
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
