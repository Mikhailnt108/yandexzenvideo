package TestSmoke.Р4_Разделы_меню.П2_ТВ_FRESH;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_12_2_Записываемая_передача_SCREENSHOT_PLAYER_Баг_нет_перемотки_вперед_при_переходе_в_карточку_запис_передачи_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Записываемая ТВ передача (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void recordedTvProgram() throws Exception {
        headerMenuPW.goToTvTabTvProgramInAir();
        flowRegistation();
        headerMenuPW.saveCookiesBrowserHeadless();
        headerMenuPW.getCookiesAndOpenHeadfullBrowser();
        headerMenuPW.goToTvTabTvProgramInAirHeadfull();
        cardTvProgramPW.chooseTailTvProgramTabInRecorder();
        cardTvProgramPW.subscribeToPackageTvProgram();
        cardTvProgramPW.clickOnRecordedTvProgramTwoDaysAgo();
        cardTvProgramPW.checkAutoStartVideoPlayer();
        cardTvProgramPW.checkImagePlayerСardTvProgramRecordedUser();
        cardTvProgramPW.checkImageScheduleСardTvProgramRecorded();
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44" , "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
