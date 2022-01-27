package TestSmokeWebDriver.S1_Sections_menu.SS8_Promotion.SSS1_Notif;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_NOTIF_Film_purchase_for_money_API extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Promotion")
    @Story(value = "1. NOTIF")
    @DisplayName(value = "Film_purchase_for_money")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31546571")
    @Test
    @Tag("SuiteWD#4")
    public void payFilmFromPopUpNotification() throws InterruptedException {
        personalOffer.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        personalOffer.archivePersonalOfferPartnerOfferOkkoTvForMF();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        personalOffer.archivePersonalOfferSubscription();
        popUpNotification.deletePopUpNotifScreenNilDeepLinkFilms();
        popUpNotification.createAndPublishedPopUpNotifScreenNilPayFilm();
        headerMenu.goToFilmsPage();
        flowRegistation();
        headerMenu.goToNilPage();
        popUpNotification.checkElementsPopUpNotifScreenNilPayFilm();
        popUpNotification.clickToButtonPayToPopUpNotif();
        paymentContent.checkOpenPopUpChoosePaymentMethodEst();
        cardFilm.paymentFilmAtEstFromPopUpNotif();
        myPage.checkAddingFilmInPurchasesForNotif();
        popUpNotification.deletePopUpNotifScreenNilPayFilm();
        pageCMS.deleteAccountMF("79260205027");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9260205027");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForFlowRegistrationMF("9260205027", "111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdn("79260205027");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForAPINotif();
    }
}
