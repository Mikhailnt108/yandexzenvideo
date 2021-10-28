package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS8_Promo_codes;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_02_NIL_PROMOCODE_Soft_TnB_Package_NC_block_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "2. NIL_PROMOCODE_Soft_TnB_Package")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#4")
    public void NIL_PROMOCODE_Soft_TnB_Package() throws IOException, InterruptedException {
        promoCodePW.createAndPublishedRC();
        promoCodePW.createAndPublishedCodeGroupAndPromoCodePackageStartSoftTnB();
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        nilPagePW.clickOnTabPromocodeAndCheckOpenFormPromocode();
        promoCodePW.inputValidPromoCode("promoCodeSoftTnB");
        promoCodePW.clickOnFirstButtonActivatePromoCode();
        promoCodePW.checkOpenPopUpBeforeActivation();
        promoCodePW.checkElementsPopUpBeforeActivationPackageStartSoftTnB();
        promoCodePW.clickToButtonCancel();
        promoCodePW.checkClosePopUpBeforeActivationPackageStartSoftTnB();
        promoCodePW.clickOnFirstButtonActivatePromoCode();
        promoCodePW.checkOpenPopUpBeforeActivation();
        promoCodePW.clickOnSecondButtonActivatePromoCode();
        promoCodePW.checkOpenPopUpAfterActivation();
        promoCodePW.checkElementsPopUpAfterActivationPackageStartSoftTnB();
        promoCodePW.clickToButtonWatchAndCheckOpenCardPackageStart();
        promoCodePW.archiveCodeGroupPackageStartSoftTnB();
        headerMenuPW.deleteAccountMF("79260192144");
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLogin("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpCreatePasswordForFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdn("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
