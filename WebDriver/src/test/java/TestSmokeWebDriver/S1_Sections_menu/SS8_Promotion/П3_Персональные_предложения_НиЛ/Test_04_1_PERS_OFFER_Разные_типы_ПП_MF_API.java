package TestSmokeWebDriver.S1_Sections_menu.SS8_Promotion.П3_Персональные_предложения_НиЛ;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_1_PERS_OFFER_Разные_типы_ПП_MF_API extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "3. Персональное предложение")
    @DisplayName(value = "Разные типы ПП MF")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#4")
    public void otherTypesPersonalOffers() throws InterruptedException {
        // проверка доступности перс предложения тип - пакет за ноль рублей для МФ
        personalOffer.createPersonalOfferTypePackageForZeroRublesForMF();
        personalOffer.archivePersonalOfferSubscription();
        personalOffer.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        headerMenu.goToFilmsPage();
        flowRegistationMF();
        headerMenu.goToNilPage();
        personalOffer.checkElementsOnePersonalOffer();
        personalOffer.clickToElementPersonalOffer();
        personalOffer.checkOpenPagePersonalOfferPackageForZeroRubles();
        personalOffer.activatePersonalOfferPackageForZeroRubles();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        pageCMS.deleteAccountMF("79260205027");

        // проверка доступности перс предложения тип - подписка для МФ
        personalOffer.createPersonalOfferTypeSubscription();
        headerMenu.goToFilmsPage();
        flowRegistationMF();
        headerMenu.goToNilPage();
        personalOffer.checkElementsOnePersonalOffer();
        personalOffer.clickToElementPersonalOffer();
        personalOffer.checkOpenPagePersonalOfferSubscription();
        personalOffer.activatePersonalOfferSubscription();
        personalOffer.archivePersonalOfferSubscription();
        pageCMS.deleteAccountMF("79260205027");

        // проверка недоступности партнерского предложения для МФ
        personalOffer.createPersonalOfferTypePartnerOfferForNonMF();
        headerMenu.goToFilmsPage();
        flowRegistationMF();
        headerMenu.goToNilPage();
        personalOffer.checkAbsentElementPersonalOffer();
        personalOffer.archivePersonalOfferTypePartnerOfferForNonMF();
        pageCMS.deleteAccountMF("79260205027");
    }

    private void flowRegistationMF() throws InterruptedException {
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

