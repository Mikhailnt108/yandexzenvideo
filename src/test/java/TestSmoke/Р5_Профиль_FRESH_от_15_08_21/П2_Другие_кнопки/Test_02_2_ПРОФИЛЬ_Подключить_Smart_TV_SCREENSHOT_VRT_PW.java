package TestSmoke.Р5_Профиль_FRESH_от_15_08_21.П2_Другие_кнопки;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_02_2_ПРОФИЛЬ_Подключить_Smart_TV_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Другие кнопки")
    @DisplayName(value = "2.2 Подключить Smart_TV (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void ConnectSmartTv() throws IOException, InterruptedException {
        headerMenuPW.goToNilPage();
        flowRegistation();
        headerMenuPW.openSubsectionConnect();
        headerMenuPW.checkImagePopUpConnectSmartTv();
        headerMenuPW.deleteAccountMF("79260192144");
    }

    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
