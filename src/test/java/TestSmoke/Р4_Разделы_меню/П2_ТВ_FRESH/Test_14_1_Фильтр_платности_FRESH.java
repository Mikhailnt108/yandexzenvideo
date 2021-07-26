package TestSmoke.Р4_Разделы_меню.П2_ТВ_FRESH;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;

public class Test_14_1_Фильтр_платности_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Разделы меню")
    @Story(value = "2. ТВ")
    @DisplayName(value ="Фильтр платности")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void checkFilterPayment() throws InterruptedException, IOException {
        headerMenu.goToTvPage();
        flowRegistation();
        tvPage.clickOnTabInRecording();
        tvPage.navigateMouseToToglPaymentOn();
        tvPage.checkTvChannelsAll();
        tvPage.clickToTailTvChannel();
        cardTvChannel.checkOpenCardTvChannel();
        cardTvChannel.clickPaymentButtonInCardTvChannel();
        cardTvChannel.checkPaymentComplete();
        headerMenu.goToTvPage();
        tvPage.clickToglePaymentForOff();
        tvPage.navigateMouseToToglePaymentOff();
        tvPage.checkTvChannelsOnlyPlugged();
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
