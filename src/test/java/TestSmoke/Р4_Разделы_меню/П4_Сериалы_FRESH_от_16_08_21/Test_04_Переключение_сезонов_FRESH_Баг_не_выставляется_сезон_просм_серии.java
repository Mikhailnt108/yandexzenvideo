package TestSmoke.Р4_Разделы_меню.П4_Сериалы_FRESH_от_16_08_21;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_04_Переключение_сезонов_FRESH_Баг_не_выставляется_сезон_просм_серии extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Переключение сезонов")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void switchingSeasons() throws Exception {
        headerMenu.goToSerialsPage();
        flowRegistation();
        serialsPage.chooseSeasonsMoreOneSeason();
        cardSerial.checkOpenCardSerial();
        cardSerial.chooseOtherSeasonAndCheckPoster();
        cardSerial.checkAutoStartVideoPlayer();
        cardSerial.paymentSerialAtSubs();
        cardSerial.moveSliderRewindToVideoPleer();
        cardSerial.checkSeasonAndEpisode();
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
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
