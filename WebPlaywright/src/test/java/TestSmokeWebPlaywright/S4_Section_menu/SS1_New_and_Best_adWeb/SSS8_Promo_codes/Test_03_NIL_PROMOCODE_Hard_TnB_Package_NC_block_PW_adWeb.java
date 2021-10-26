package TestSmokeWebPlaywright.S4_Section_menu.SS1_New_and_Best_adWeb.SSS8_Promo_codes;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Test_03_NIL_PROMOCODE_Hard_TnB_Package_NC_block_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "1. New_and_Best_adWeb")
    @DisplayName(value = "3. NIL_PROMOCODE_Hard_TnB_Package")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#1")
    public void NIL_PROMOCODE_Hard_TnB_Package() throws IOException, InterruptedException {
        promoCodePW.createAndPublishedRC();
        promoCodePW.createAndPublishedCodeGroupAndPromoCodePackageMoreTvHardTnB();
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        nilPagePW.clickOnTabPromocodeAndCheckOpenFormPromocode();
        promoCodePW.inputValidPromoCode("promoCodeHardTnB");
        promoCodePW.clickOnFirstButtonActivatePromoCode();
        promoCodePW.checkOpenPopUpBeforeActivation();
        promoCodePW.checkElementsPopUpBeforeActivationPackageMoreTvHardTnB();
        promoCodePW.clickOnSecondButtonActivatePromoCode();
        promoCodePW.checkOpenPopUpAfterActivation();
        promoCodePW.checkElementsPopUpAfterActivationPackageMoreTvHardTnB();
        promoCodePW.clickToButtonCloseInPopUpAfterActivation();
        promoCodePW.checkClosePopUpAfterActivation();
        promoCodePW.archiveCodeGroupPackageMoreTvHardTnB();
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
