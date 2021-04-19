package TestSmoke.Р2_Разделы_меню.П2_ТВ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_13_Фильтр_платности_НАШЕЛ_БАГ_ОДИНАКОВЫЕ_ПОДСКАЗКИ extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Фильтр платности")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkFilterPayment() {
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.checkOpenTabTvPageSchedule();
        tvPage.clickOnTabHD();
        tvPage.navigateMouseToToglPaymentOn();
        tvPage.clickToglPaymentForOff();
        tvPage.checkTvChannelsOnlyAvailable();
        tvPage.navigateMouseToToglPaymentOff();
        tvPage.clickToglPaymentForOn();
        tvPage.checkTvChannelsOnlyPayment();
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
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
