package TestSmoke.Р5_Профиль_FRESH_от_15_08_21.П1_Акции.пп1_ТП_БезПереплат_FRESH;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_03_БезПереплат_Интернет extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="БезПереплат.Интернет")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void bundlBezPereplatMax() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.chooseBundleBezPereplatInternetFromMsisdn("79260192144");
        headerMenu.closePopUpNotif();
        headerMenu.openSubsectionPromo();
        promoPage.checkBundleBezPereplatInternet();
        pageCMS.chooseBundleNotSelected("79260192144");
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
