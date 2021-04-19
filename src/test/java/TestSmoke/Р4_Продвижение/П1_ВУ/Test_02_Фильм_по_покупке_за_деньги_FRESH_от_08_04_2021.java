package TestSmoke.Р4_Продвижение.П1_ВУ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_Фильм_по_покупке_за_деньги_FRESH_от_08_04_2021 extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "1. ВУ")
    @DisplayName(value = "Фильм по покупке за деньги")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void payFilmFromPopUpNotification() {
        popUpNotification.createAndPublishedPopUpNotifScreenNilPayFilm();
        headerMenu.goToNilPage();
        flowRegistation();
        popUpNotification.checkElementsPopUpNotifScreenNilPayFilm();
        popUpNotification.clickToButtonPayToPopUpNotif();
        paymentContent.checkOpenPopUpChoosePaymentMethodEst();
        cardFilm.paymentFilmAtEstFromPopUpNotif();
        myPage.checkAddingFilmInPurchases();
        popUpNotification.deletePopUpNotifScreenNilPayFilm();
        pageCMS.deleteAccountMF("79260172279");
    }
    private void flowRegistation() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9260172279");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260172279", "111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260172279");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}
