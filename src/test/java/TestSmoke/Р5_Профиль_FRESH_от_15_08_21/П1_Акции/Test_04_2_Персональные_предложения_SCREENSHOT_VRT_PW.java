package TestSmoke.Р5_Профиль_FRESH_от_15_08_21.П1_Акции;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_04_2_Персональные_предложения_SCREENSHOT_VRT_PW extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "3. Профиль")
    @Story(value = "2. Акции")
    @DisplayName(value ="4.2 Персональные предложения (скриншоты)")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void personalOffers() throws InterruptedException, IOException {
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
        headerMenuPW.checkOpenPopUpInputPhone();
        headerMenuPW.inputLogin("+7 926 020 50 27");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 020 50 27", "111111");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260205027");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
    }
}
