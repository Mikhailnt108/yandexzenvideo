package TestSmoke.Р2_Продвижение_FRESH_от_16_04_2021.П3_Персональные_предложения_НиЛ;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_04_Разные_типы_ПП extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "3. Персональное предложение")
    @DisplayName(value = "Разные типы ПП")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id = "138")
    public void otherTypesPersonalOffers() {
        //проверка доступности перс предложения тип - пакет за ноль рублей для МФ
        personalOffer.createPersonalOfferTypePackageForZeroRublesForMF();
        personalOffer.archivePersonalOfferSubscription();
        personalOffer.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        headerMenu.goToNilPage();
        flowRegistationMF();
        personalOffer.checkElementsOnePersonalOffer();
        personalOffer.clickToElementPersonalOffer();
        personalOffer.checkOpenPagePersonalOfferPackageForZeroRubles();
        personalOffer.activatePersonalOfferPackageForZeroRubles();
        pageCMS.deleteAccountMF("79260192144");

        //проверка недоступности перс предложения тип - пакет за ноль рублей для НЕ МФ
        headerMenu.goToNilPage();
        flowRegistationNonMF();
        personalOffer.checkAbsentElementPersonalOffer();
        personalOffer.archivePersonalOfferPackageForZeroRublesForMF();
        headerMenu.logOut();

        //проверка доступности перс предложения тип - подписка для МФ
        personalOffer.createPersonalOfferTypeSubscription();
        flowRegistationMF();
        personalOffer.checkElementsOnePersonalOffer();
        personalOffer.clickToElementPersonalOffer();
        personalOffer.checkOpenPagePersonalOfferSubscription();
        personalOffer.activatePersonalOfferSubscription();
        pageCMS.deleteAccountMF("79260192144");

        //проверка доступности перс предложения тип - подписка для НЕ МФ
        headerMenu.goToNilPage();
        flowAuthorizationNonMF();
        personalOffer.checkElementsOnePersonalOffer();
        personalOffer.clickToElementPersonalOffer();
        personalOffer.checkOpenPagePersonalOfferSubscription();
        personalOffer.archivePersonalOfferSubscription();

        //проверка доступности партнерсокго предложения для НЕ МФ
        personalOffer.createPersonalOfferTypePartnerOfferForNonMF();
        headerMenu.goToNilPage();
        headerMenu.logOut();
        flowAuthorizationNonMF();
        personalOffer.checkElementsOnePersonalOffer();
        personalOffer.clickToElementPersonalOffer();
        personalOffer.checkOpenPagePersonalOfferPartnerOffer();
        personalOffer.clickButtonPartner();
        personalOffer.checkOpenPageURLPartner();
        pageCMS.deleteAccountNonMF("79261184972");

        //проверка недоступности партнерсокго предложения для МФ
        headerMenu.goToNilPage();
        flowRegistationMF();
        personalOffer.checkAbsentElementPersonalOffer();
        personalOffer.archivePersonalOfferPartnerOfferKinoPoiskForMF();
        pageCMS.deleteAccountMF("79260192144");
    }

    private void flowRegistationMF() {
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

    private void flowRegistationNonMF() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.checkOpenPopUpInputPhone();
        headerMenu.inputLogin("9261184972");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputEmail("9261184972");
        headerMenu.checkElementsPopUpInputEmail();
        headerMenu.inputValidEmailInPopUpInputEmail("ispolnitel1mt@yandex.ru");
        headerMenu.clickToCheckBoxInPopUpEmail();
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpCreatePasswordForNonMF();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkOpenPopUpInputCode();
        pageCMS.copyPasteCodMsisdnForNonMF("79261184972");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectForNonMegafon();
    }

    private void flowAuthorizationNonMF() {
        headerMenu.checkNotLoggedIsCorrect();
        headerMenu.clickToEnter("Вход");
        headerMenu.inputLogin("9261184972");
        headerMenu.clickToNext("Далее");
        headerMenu.checkOpenPopUpInputPassword();
        headerMenu.inputSixSimbolPassword("111111");
        headerMenu.clickToComeIn("Войти");
        headerMenu.checkLoginUserIsCorrectFlow();
    }
}

