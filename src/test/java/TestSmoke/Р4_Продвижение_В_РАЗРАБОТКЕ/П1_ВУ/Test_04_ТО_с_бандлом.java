package TestSmoke.Р4_Продвижение_В_РАЗРАБОТКЕ.П1_ВУ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_04_ТО_с_бандлом extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "1. ВУ")
    @DisplayName(value = "ТО с бандлом")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void popUpNotificationMyTarifBundle() {
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.checkLoginUserIsCorrect();
        popUpNotification.checkElementsPopUpBundleUserMF();
        popUpNotification.clickButtonWatchInPopUpBundle();
        promoPage.checkOpenPromoPage();
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
    }
}
