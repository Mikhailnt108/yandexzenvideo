package TestSmokeWeb.Р3_Продвижение_FRESH_от_15_08_2021.П3_Персональные_предложения_НиЛ;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock(value = "Suite#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_02_ПП_разные_состояния_API extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "3. Персональное предложение")
    @DisplayName(value = "ПП разные состояния")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("Suite#3")
    public void POdifferentState() {
        personalOffer.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        personalOffer.archivePersonalOfferPartnerOfferOkkoTvForMF();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        personalOffer.archivePersonalOfferSubscription();
        personalOffer.createPersonalOfferTypePackageForZeroRublesForMF();
        headerMenu.goToNilPage();
        flowRegistation();
        personalOffer.checkElementsWhiteColorSandPersonalOffer();
        personalOffer.checkElementsYellowColorSandPersonalOffer();
        personalOffer.checkElementsRedColorSandPersonalOffer();
        personalOffer.clickToElementPersonalOffer();
        personalOffer.checkOpenPagePersonalOfferPackageForZeroRubles();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        pageCMS.deleteAccountMF("79260205027");
    }

    private void flowRegistation() {
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

