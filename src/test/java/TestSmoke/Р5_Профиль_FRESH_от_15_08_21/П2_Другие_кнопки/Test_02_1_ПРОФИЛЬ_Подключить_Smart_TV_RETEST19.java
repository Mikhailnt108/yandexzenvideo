package TestSmoke.Р5_Профиль_FRESH_от_15_08_21.П2_Другие_кнопки;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_1_ПРОФИЛЬ_Подключить_Smart_TV_RETEST19 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Другие кнопки")
    @DisplayName(value ="2.1 Подключить Smart_TV")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void ConnectSmartTv() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.noConnectSmartTv();
        headerMenu.connectSmartTv();
        pageCMS.deleteAccountMF("79260205027");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260205027");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260205027", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260205027");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}
