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

import java.io.IOException;

@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "Suite#1", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_1_Карточка_канала_RETEST19 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "0. Разделы меню")
    @Story(value = "1. ТВ")
    @DisplayName(value ="Карточка канала")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#1")
    public void cardTvChannel() throws IOException, InterruptedException {
        // неавторизованный пользователь:
        headerMenu.goToTvPage();
        tvPage.checkOpenTvPageTabScheduleTv();
        tvPage.clickOnTabInRecording();
        tvPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        cardTvChannel.checkElementsInCardTvChannel();
        // авторизованный пользователь:
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.clickOnTabInRecording();
        tvPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        cardTvChannel.clickPaymentButtonInCardTvChannel();
        cardTvChannel.checkPaymentComplete();
        headerMenu.refreshPage();
        cardTvChannel.checkAutoStartVideoPlayer();
        cardTvChannel.checkButtonFavoriteNotAdded();
        cardTvChannel.clickOnButtonFavorite();
        cardTvChannel.checkButtonFavoriteAdded();
        cardTvChannel.clickOnTvProgramInCardChannel();
        cardTvProgram.checkOpenCardTvProgram();
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
