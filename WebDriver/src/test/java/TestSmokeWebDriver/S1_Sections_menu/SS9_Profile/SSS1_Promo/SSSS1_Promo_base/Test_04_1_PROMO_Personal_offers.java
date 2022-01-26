package TestSmokeWebDriver.S1_Sections_menu.SS9_Profile.SSS1_Promo.SSSS1_Promo_base;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_1_PROMO_Personal_offers extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Profile")
    @Story(value = "2. Promo")
    @DisplayName(value ="Personal_offers")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#4")
    public void personalOffers() throws InterruptedException {
        personalOffer.createPersonalOfferTypePackageForZeroRublesForMF();
        personalOffer.createPersonalOfferTypeSubscription();
        personalOffer.createPersonalOfferTypePartnerOfferKinoPoiskForMF();
        personalOffer.createPersonalOfferTypePartnerOfferOkkoTvForMF();
        headerMenu.goToFilmsPage();
        flowRegistation();
        headerMenu.goToNilPage();
        headerMenu.openSubsectionPromo();
        promoPage.checkElementsBlockPersonalOffers();
//        promoPage.scrollPersonalOffers();
        promoPage.clickToBlockPersonalOfferTypeSubscription();
        personalOffer.checkElementsPersonalOfferPage();
        personalOffer.clickTolinkViewAllPromotions();
        promoPage.checkOpenPromoPage();
        headerMenu.goToBack();
        personalOffer.clickToTailPackageInPO();
        cardPackage.checkOpenCardPackage();
        headerMenu.goToPromoPage();
        promoPage.clickToBlockPersonalOfferTypePackageForZeroRublesForMF();
        personalOffer.activatePersonalOfferPackageForZeroRubles();
        headerMenu.goToPromoPage();
        promoPage.clickToBlockPersonalOfferTypePartner();
        personalOffer.clickToButtonNotInterested();
        headerMenu.goToPromoPage();
        promoPage.checkAbsentBlockPoNotInterested();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        personalOffer.archivePersonalOfferSubscription();
        personalOffer.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        personalOffer.archivePersonalOfferPartnerOfferOkkoTvForMF();
        pageCMS.deleteAccountMF("79260205027");
    }
    private void flowRegistation() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
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
