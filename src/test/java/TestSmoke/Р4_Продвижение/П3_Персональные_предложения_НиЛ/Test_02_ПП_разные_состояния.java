package TestSmoke.Р4_Продвижение.П3_Персональные_предложения_НиЛ;

import base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test_02_ПП_разные_состояния extends TestBase {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "4. Продвижение")
    @Story(value = "3. Персональное предложение")
    @DisplayName(value = "ПП разные состояния")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void POdifferentState() {
        personalOffer.createPersonalOfferTypePackageForZeroRubles();
        headerMenu.goToNilPage();
        flowRegistation();
        personalOffer.checkElementsWhiteColorSandPersonalOffer();
        personalOffer.checkElementsYellowColorSandPersonalOffer();
        personalOffer.checkElementsRedColorSandPersonalOffer();
        personalOffer.clickToElementPersonalOffer();
        personalOffer.checkOpenPagePersonalOfferPackageForZeroRubles();
        personalOffer.archivePersonalOfferPackageForZeroRubles();
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

