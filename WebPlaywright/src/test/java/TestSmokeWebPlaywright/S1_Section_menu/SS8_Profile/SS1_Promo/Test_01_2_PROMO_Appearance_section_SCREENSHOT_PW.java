package TestSmokeWebPlaywright.S1_Section_menu.SS8_Profile.SS1_Promo;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "SuitePwNonAdWeb#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_01_2_PROMO_Appearance_section_SCREENSHOT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "1. Sections_menu")
    @Story(value = "8. Profile_Promo")
    @DisplayName(value ="01_2_PROMO_Appearance_section_SCREENSHOT")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuitePwNonAdWeb#4")
    public void PROMO_Appearance_section_SCREENSHOT() throws InterruptedException, IOException {
        headerMenuPW.goToFilmsPage();
        flowRegistationMF();
        headerMenuPW.goToFilmsPage();
        headerMenuPW.openSubsectionPromo();
        personalOfferPW.archivePersonalOfferPackageForZeroRublesForMF();
        personalOfferPW.archivePersonalOfferSubscription();
        personalOfferPW.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        personalOfferPW.archivePersonalOfferPartnerOfferOkkoTvForMF();
//        headerMenuPW.chooseBundleNotSelected("79260205027");
        promoPagePW.checkImagePromoPageWithoutPersonalOffers();
        personalOfferPW.createPersonalOfferTypePackageForZeroRublesForMF();
        personalOfferPW.createPersonalOfferTypeSubscription();
        personalOfferPW.createPersonalOfferTypePartnerOfferKinoPoiskForMF();
        personalOfferPW.createPersonalOfferTypePartnerOfferOkkoTvForMF();
        headerMenuPW.goToFilmsPage();
        headerMenuPW.logOut();
        flowAuthorization();
        headerMenuPW.openSubsectionPromo();
        promoPagePW.checkImagePromoPageWithPersonalOffers();
        personalOfferPW.archivePersonalOfferPackageForZeroRublesForMF();
        personalOfferPW.archivePersonalOfferSubscription();
        personalOfferPW.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        personalOfferPW.archivePersonalOfferPartnerOfferOkkoTvForMF();
        headerMenuPW.deleteAccountMF("79260205027");
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginNonAdWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForNonAdWebFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForNonAdWeb("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260205027");
    }
    private void flowAuthorization() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginAdWeb("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        authPagePW.inputValidPasswordRegister("111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
