package TestSmoke.Р4_Разделы_меню.П4_Сериалы_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_10_Выбор_серии_из_плеера_Дополнить_шаги_теста_SCREENSHOT_PLAYER_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Выбор серии из плеера (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void chooseEpisodeFromBlockEpisodes() throws Exception {
        // авторизованный пользователь:
        headerMenuPW.goToSerialsPage();
        flowRegistation();
        serialsPagePW.clickToTailCardSerial();
        cardSerialPW.checkOpenCardSerial();
        cardSerialPW.subscribeToPackageSerials();
        headerMenuPW.saveCookiesBrowserHeadless();
        headerMenuPW.getCookiesAndOpenHeadfullBrowser();
        headerMenuPW.goToSerialsPageHeadfull();
        serialsPagePW.clickToTailCardSerialHeadfull();
        cardSerialPW.clickToButtonWatchHeadfull();
        cardSerialPW.checkStartVideoPlayerHeadfull();
        cardSerialPW.checkImageSwitchEpisodeInPlayerHeadfull();
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
