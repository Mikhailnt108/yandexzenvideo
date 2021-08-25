package TestSmoke.Р2_Продвижение_FRESH_от_15_08_2021.П2_Промокод;

import base.TestBaseWebDriver;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.parallel.ResourceLock;

@ResourceLock("Suite#3")
public class Test_04_Фильм_по_аренде_API extends TestBaseWebDriver {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "2. Промокод")
    @DisplayName(value = "Фильм по аренде")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    public void filmOnRentPromo() {
        promoCode.createAndPublishedRC();
        promoCode.createAndPublishedCodeGroupAndPromoCodeFilmOnRentPromo();
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.clickToButtonPromo();
        headerMenu.checkOpenPopUpPromoCode();
        headerMenu.inputValidPromoCode("promoCodeFilmOnRent");
        headerMenu.clickToButtonActivatePromoCode();
        headerMenu.checkOpenPopUpBeforeActivation();
        headerMenu.checkElementsPopUpBeforeActivationFilmOnRent();
        headerMenu.clickToButtonActivatePromoCode();
        headerMenu.checkOpenPopUpAfterActivation();
        headerMenu.checkElementsPopUpAfterActivationFilmOnRent();
        headerMenu.clickToButtonMoreDetailedAndCheckOpenCardFilmOnRent();
        promoCode.archiveCodeGroupFilmOnRentPromo();
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
