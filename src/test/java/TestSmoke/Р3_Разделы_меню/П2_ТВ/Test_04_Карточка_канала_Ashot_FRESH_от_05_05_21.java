package TestSmoke.Р3_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_04_Карточка_канала_Ashot_FRESH_от_05_05_21 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Карточка канала")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void cardTvChannel() throws IOException, InterruptedException {
        // неавторизованный пользователь:
        headerMenu.goToTvPage();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabInRecording();
        tvPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        cardTvChannel.checkElementsInCardTvChannel();
        cardTvChannel.checkImageDifferCardTvChannelForUnauthorized();
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
