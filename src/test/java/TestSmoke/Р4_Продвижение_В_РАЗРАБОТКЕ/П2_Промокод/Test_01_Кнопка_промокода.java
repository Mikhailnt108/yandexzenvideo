package TestSmoke.Р4_Продвижение_В_РАЗРАБОТКЕ.П2_Промокод;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class Test_01_Кнопка_промокода extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "2. Промокод")
    @DisplayName(value = "Кнопка промокода")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void clickButtonPromoCodeAndInputPromoCode() {
        //promoCode.createAndPublishedPkCodeGroupAndPromoCodePackageStartSoftTnB();
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.clickToButtonPromo();
        headerMenu.checkOpenPopUpPromoCode();
        headerMenu.checkElementsPopUpPromoCode();
        headerMenu.inputInvalidPromoCode("12345");
        headerMenu.checkActiveButtonActivatePromoCode();
        headerMenu.clickToButtonActivatePromoCode();
        headerMenu.checkErrorMessage3();
        headerMenu.inputValidPromoCode("promoCodeAutoTest");
        headerMenu.clickToButtonActivatePromoCode();
        headerMenu.checkOpenPopUpBeforeActivation();
        headerMenu.clickToButtonActivatePromoCode();
        headerMenu.checkOpenPopUpAfterActivation();
        promoCode.archiveCodeGroupPackageStartSoftTnB();
        pageCMS.deleteAccountMF();
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
