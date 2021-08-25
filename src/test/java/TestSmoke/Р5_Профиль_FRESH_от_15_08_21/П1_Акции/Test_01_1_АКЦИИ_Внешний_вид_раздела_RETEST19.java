package TestSmoke.Р5_Профиль_FRESH_от_15_08_21.П1_Акции;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

public class Test_01_1_АКЦИИ_Внешний_вид_раздела_RETEST19 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="1.1 Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearancePagePromo() throws InterruptedException, IOException, AWTException {
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.chooseBundleNotSelected("79260205027");
        headerMenu.openSubsectionPromo();
        promoPage.checkElementsWithoutBlockPersonalOffer();
        promoPage.checkExpandDiscriptionPromo();
        promoPage.checkHideDiscriptionPromo();
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
