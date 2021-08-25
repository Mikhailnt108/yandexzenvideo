package TestSmoke.Р5_Профиль_FRESH_от_15_08_21.П1_Акции;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_04_1_Персональные_предложения_FRESH extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="4.1 Персональные предложения")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void personalOffers() throws InterruptedException {
        personalOffer.createPersonalOfferTypePackageForZeroRublesForMF();
        personalOffer.createPersonalOfferTypeSubscription();
        personalOffer.createPersonalOfferTypePartnerOfferKinoPoiskForMF();
        personalOffer.createPersonalOfferTypePartnerOfferOkkoTvForMF();
        headerMenu.goToNilPage();
        flowRegistation();
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
