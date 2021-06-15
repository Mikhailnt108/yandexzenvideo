package TestSmoke.Р2_Продвижение_FRESH_от_16_04_2021.П3_Персональные_предложения_НиЛ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_03_Несколько_ПП extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "3. Персональное предложение")
    @DisplayName(value = "Несколько ПП")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void fewPersonalOffers() {
        personalOffer.createPersonalOfferTypePackageForZeroRublesForMF();
        personalOffer.createPersonalOfferTypeSubscription();
        headerMenu.goToNilPage();
        flowRegistation();
        personalOffer.checkElementsFewPersonalOffers();
        personalOffer.clickToElementPersonalOffer();
        promoPage.checkOpenPromoPage();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        personalOffer.archivePersonalOfferSubscription();
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
