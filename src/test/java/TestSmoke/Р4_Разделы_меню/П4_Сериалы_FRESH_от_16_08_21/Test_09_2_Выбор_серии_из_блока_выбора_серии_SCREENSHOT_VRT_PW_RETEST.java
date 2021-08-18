package TestSmoke.Р4_Разделы_меню.П4_Сериалы_FRESH_от_16_08_21;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test_09_2_Выбор_серии_из_блока_выбора_серии_SCREENSHOT_VRT_PW_RETEST extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "4. Сериалы")
    @DisplayName(value ="9.2 Выбор серии из блока выбора серии (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void chooseEpisodeFromBlockEpisodes() throws Exception {
        // пользователь НЕ авторизован:
        headerMenuPW.goToSerialsPage();
        serialsPagePW.chooseSeasonsMoreOneSeason();
        cardSerialPW.checkOpenCardSerial();
        cardSerialPW.checkImageBlockSeason();
        // пользователь авторизован:
        headerMenuPW.goToSerialsPage();
        flowRegistation();
        serialsPagePW.clickToTailCardSerial();
        cardSerialPW.checkOpenCardSerial();
        cardSerialPW.checkImagePopUpSubscription();
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
