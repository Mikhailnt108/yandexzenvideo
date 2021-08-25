package TestSmoke.Р2_Продвижение_FRESH_от_15_08_2021.П3_Персональные_предложения_НиЛ;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#3")
public class Test_03_Несколько_ПП_API extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "3. Персональное предложение")
    @DisplayName(value = "Несколько ПП")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void fewPersonalOffers() throws InterruptedException {
        personalOffer.createPersonalOfferTypePackageForZeroRublesForMF();
        personalOffer.createPersonalOfferTypeSubscription();
        headerMenu.goToNilPage();
        flowRegistation();
        personalOffer.checkElementsFewPersonalOffers();
        personalOffer.clickToElementPersonalOffer();
        promoPage.checkOpenPromoPage();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        personalOffer.archivePersonalOfferSubscription();
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
