package TestSmokeWebPlaywright.Р4_Разделы_меню.П3_Сериалы_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "SuitePW", mode = ResourceAccessMode.READ_WRITE)
public class Test_10_Выбор_серии_из_плеера_Дополнить_шаги_теста_SCREENSHOT_PLAYER_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="Выбор серии из плеера (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#4")
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
        headerMenuPW.inputLogin("+7 925 011 01 66");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 925 011 01 66" , "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79250110166");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
