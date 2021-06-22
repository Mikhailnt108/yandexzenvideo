package TestSmoke.Р2_Продвижение_FRESH_от_16_04_2021.П2_Промокод;

import base.TestBase;
import com.github.rsheremeta.testrail.TestRailCase;
import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test_02_Пакет_по_Мягкому_TnB extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "2. Промокод")
    @DisplayName(value = "Пакет по Мягкому TnB")
    @Severity(SeverityLevel.BLOCKER)
    @RepeatedTest(1)
    @TestRailCase(id="131")
    public void packageSoftTnB() {
        promoCode.createAndPublishedRC();
        promoCode.createAndPublishedCodeGroupAndPromoCodePackageStartSoftTnB();
        headerMenu.goToNilPage();
        flowRegistation();
        headerMenu.clickToButtonPromo();
        headerMenu.checkOpenPopUpPromoCode();
        headerMenu.inputValidPromoCode("promoCodeSoftTnB");
        headerMenu.clickToButtonActivatePromoCode();
        headerMenu.checkOpenPopUpBeforeActivation();
        headerMenu.checkElementsPopUpBeforeActivationPackageStartSoftTnB();
        headerMenu.clickToButtonCancel();
        headerMenu.checkClosePopUpBeforeActivationPackageStartSoftTnB();
        headerMenu.clickToButtonActivatePromoCode();
        headerMenu.checkOpenPopUpBeforeActivation();
        headerMenu.clickToButtonActivatePromoCode();
        headerMenu.checkOpenPopUpAfterActivation();
        headerMenu.checkElementsPopUpAfterActivationPackageStartSoftTnB();
        headerMenu.clickToButtonMoreDetailedAndCheckOpenCardPackageStart();
        promoCode.archiveCodeGroupPackageStartSoftTnB();
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
