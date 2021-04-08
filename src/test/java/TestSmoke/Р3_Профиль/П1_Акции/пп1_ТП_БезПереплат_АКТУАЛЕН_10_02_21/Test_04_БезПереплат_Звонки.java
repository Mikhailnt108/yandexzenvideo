package TestSmoke.Р3_Профиль.П1_Акции.пп1_ТП_БезПереплат_АКТУАЛЕН_10_02_21;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_04_БезПереплат_Звонки extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="БезПереплат.Звонки")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void bundlBezPereplatMax() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.chooseBundleBezPereplatZvonkiFromMsisdn("79260192144");
        headerMenu.openSubsectionPromo();
        promoPage.checkBundleBezPereplatZvonki();
        pageCMS.deleteAccountMF();
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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
