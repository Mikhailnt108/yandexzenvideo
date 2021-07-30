package TestSmoke.Р4_Разделы_меню.П4_Сериалы;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_10_2_Выбор_серии_из_плеера_SCREENSHOT_VRT_Playwright_FRESH_NEED_COMPLETE extends TestBasePlaywright {
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
        serialsPagePW.clickToFirstTailCardSerial();
        cardSerialPW.checkOpenCardSerial();
        cardSerialPW.subscribeToPackageSerials();
        cardSerialPW.clickToButtonWatch();
        cardSerialPW.checkAutoStartTrailerPlayer();
        cardSerialPW.checkImageSwitchEpisodeInPlayer();
        headerMenuPW.deleteAccountMF("79260192144");
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
        headerMenuPW.checkLoginUserIsCorrectFlowForMF();
    }
}
