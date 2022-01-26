package TestSmokeWebDriver.S1_Sections_menu.SS8_Promotion.SSS3_Personal_Offers_Nil;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

//@Execution(ExecutionMode.SAME_THREAD)
@ResourceLock(value = "SuiteWD#4", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_2_PERS_OFFER_Several_type_pers_offer_Non_MF_API extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Promotion")
    @Story(value = "3. Personal offer")
    @DisplayName(value = "Several_type_pers_offe_Non_MF")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("SuiteWD#4")
    public void otherTypesPersonalOffers() throws InterruptedException {
        // проверка недоступности перс предложения тип - пакет за ноль рублей для НЕ МФ
        personalOffer.createPersonalOfferTypePackageForZeroRublesForMF();
        personalOffer.archivePersonalOfferSubscription();
        personalOffer.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        headerMenu.goToFilmsPage();
        flowRegistationNonMF();
        headerMenu.goToNilPage();
        personalOffer.checkAbsentElementPersonalOffer();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        headerMenu.logOut();

        // проверка доступности перс предложения тип - подписка для НЕ МФ
        personalOffer.createPersonalOfferTypeSubscription();
        headerMenu.goToFilmsPage();
        flowAuthorizationNonMF();
        headerMenu.goToNilPage();
        personalOffer.checkElementsOnePersonalOffer();
        personalOffer.clickToElementPersonalOffer();
        personalOffer.checkOpenPagePersonalOfferSubscription();
        personalOffer.archivePersonalOfferSubscription();

        // проверка доступности партнерсокго предложения для НЕ МФ
        personalOffer.createPersonalOfferTypePartnerOfferForNonMF();
        headerMenu.goToFilmsPage();
        headerMenu.logOut();
        flowAuthorizationNonMF();
        headerMenu.goToNilPage();
        personalOffer.checkElementsOnePersonalOffer();
        personalOffer.clickToElementPersonalOffer();
        personalOffer.checkOpenPagePersonalOfferPartnerOffer();
        personalOffer.clickButtonPartner();
        personalOffer.checkOpenPageURLPartner();
        personalOffer.archivePersonalOfferTypePartnerOfferForNonMF();
        pageCMS.deleteAccountNonMF("79261184972");
    }

    private void flowRegistationNonMF() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPageInputPhone();
        headerMenu.inputLogin("9261184972");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputEmail("9261184972");
        headerMenu.inputValidEmailInPopUpInputEmail("ispolnitel1mt@yandex.ru");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForNonMF();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdnForNonMF("79261184972");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForNonMF();
    }

    private void flowAuthorizationNonMF() throws InterruptedException {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.inputLogin("9261184972");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputPassword();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlowForMF();
    }
}

