package TestSmokeWebPlaywright.S1_Section_menu.SS4_Serials;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuitePwNonAdWeb#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_09_2_SERIALS_Choose_episode_from_block_episodes_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "4. Serials")
    @DisplayName(value ="09_2_SERIALS_Choose_episode_from_block_episodes_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("35669382")
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void SERIALS_Choose_episode_from_block_episodes_SCREENSHOT() throws Exception {
        // пользователь НЕ авторизован:
        headerMenuPW.goToSerialsPage();
        serialsPagePW.chooseSeasonsMoreOneSeason();
        cardSerialPW.checkOpenCardSerial();
        cardSerialPW.checkImageBlockSeason();
        // пользователь авторизован:
        headerMenuPW.goToSerialsPage();
        flowRegistationMF();
        headerMenuPW.goToSerialsPage();
        serialsPagePW.clickToTailCardSerial();
        cardSerialPW.checkOpenCardSerial();
        cardSerialPW.checkImagePopUpSubscription();
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginNonAdWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForNonAdWeb("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
}
