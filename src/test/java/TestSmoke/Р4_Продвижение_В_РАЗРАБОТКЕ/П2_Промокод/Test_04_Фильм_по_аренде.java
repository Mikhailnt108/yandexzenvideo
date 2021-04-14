package TestSmoke.Р4_Продвижение_В_РАЗРАБОТКЕ.П2_Промокод;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_04_Фильм_по_аренде extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "2. Промокод")
    @DisplayName(value = "Фильм по аренде")
    @Severity(SeverityLevel.BLOCKER)
    @Test
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
