package TestSmoke.Р5_Профиль.П1_Акции;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

public class Test_01_Внешний_вид_раздела_ДОБАВИТЬ_ASHOT_FRESH_от_15_06_21 extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="Внешний вид раздела")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void appearancePagePromo() throws InterruptedException, IOException, AWTException {
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.openSubsectionPromo();
        promoPage.checkElementsWithoutBlockPersonalOffer();
        promoPage.checkExpandDiscriptionPromo();
        promoPage.checkHideDiscriptionPromo();

        promoPage.imageDifferBlockTarif();
        promoPage.imageDifferBlockPromotions();
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
