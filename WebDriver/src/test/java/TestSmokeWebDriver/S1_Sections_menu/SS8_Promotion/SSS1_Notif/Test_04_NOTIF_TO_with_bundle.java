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
public class Test_04_NOTIF_TO_with_bundle extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Promotion")
    @Story(value = "1. NOTIF")
    @DisplayName(value = "TO_with_bundle")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31546574")
    @Test
    @Tag("SuiteWD#4")
    public void popUpNotificationMyTarifBundle() throws InterruptedException {
        personalOffer.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        personalOffer.archivePersonalOfferPartnerOfferOkkoTvForMF();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        personalOffer.archivePersonalOfferSubscription();
        popUpNotification.deletePopUpNotifScreenFilms();
        popUpNotification.deletePopUpNotifScreenNilPayFilm();
        headerMenu.goToNilPage();
        flowRegistation();
        pageCMS.chooseBundleCorpBezlimitFromMsisdnNonCloseNotif("79260205027");
        headerMenu.checkElementsPopUpBundleUserMF();
        popUpNotification.clickButtonWatchInPopUpBundle();
        promoPage.checkOpenPromoPage();
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
    }
}
