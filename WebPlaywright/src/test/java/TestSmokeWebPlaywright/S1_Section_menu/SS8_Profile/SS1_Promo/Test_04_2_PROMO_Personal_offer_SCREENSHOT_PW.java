package TestSmokeWebPlaywright.S1_Section_menu.SS8_Profile.SS1_Promo;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "SuitePW#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_2_PROMO_Personal_offer_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "8. Profile_Promo")
    @DisplayName(value ="04_2_PROMO_Personal_offer_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePW#4")
    public void PROMO_Personal_offer_SCREENSHOT() throws InterruptedException, IOException {
        personalOfferPW.createPersonalOfferTypePackageForZeroRublesForMF();
        personalOfferPW.createPersonalOfferTypeSubscription();
        personalOfferPW.createPersonalOfferTypePartnerOfferKinoPoiskForMF();
        personalOfferPW.createPersonalOfferTypePartnerOfferOkkoTvForMF();
        headerMenuPW.goToNilPage();
        flowRegistation();
        headerMenuPW.openSubsectionPromo();
        promoPagePW.checkImageBlockPersonalOffers();
        promoPagePW.clickToBlockPersonalOfferTypeSubscription();
        personalOfferPW.checkImagePagePersonalOfferSubscription();
        personalOfferPW.archivePersonalOfferPackageForZeroRublesForMF();
        personalOfferPW.archivePersonalOfferSubscription();
        personalOfferPW.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        personalOfferPW.archivePersonalOfferPartnerOfferOkkoTvForMF();
        headerMenuPW.deleteAccountMF("79260205027");
    }
    private void flowRegistation() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
