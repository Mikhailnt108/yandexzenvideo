package TestSmokeWeb.Р5_Профиль_FRESH_от_15_08_21.П1_Акции.пп2_ТП_VIP_or_Премиум;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_Премиум_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="Премиум")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#3Exp")
    public void bundlPremium() throws InterruptedException {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.chooseBundlePremiumFromMsisdn("79260205027");
        headerMenu.closePopUpNotif();
        headerMenu.openSubsectionPromo();
        promoPage.checkBundlePremium();
        pageCMS.chooseBundleNotSelected("79260205027");
        pageCMS.deleteAccountMF("79260205027");
    }
    private void flowRegistation() throws InterruptedException {
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
