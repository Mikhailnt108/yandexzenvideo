package S1_New_and_Best_adMWEB.SSS8_Promo_codes;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;

@ResourceLock(value = "adWebSuitePW#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_06_NIL_PROMOCODE_Reusing_promo_code_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "6. NIL_PROMOCODE_Reusing_promo_code")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_PROMOCODE_Reusing_promo_code() throws IOException, InterruptedException {
        promoCodePW.createAndPublishedRC();
        promoCodePW.createAndPublishedCodeGroupAndPromoCodePackageStartSoftTnB();
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        nilPagePW.clickOnTabPromocodeAndCheckOpenFormPromocode();
        promoCodePW.inputValidPromoCode("promoCodeSoftTnB");
        promoCodePW.clickOnFirstButtonActivatePromoCode();
        promoCodePW.checkOpenPopUpBeforeActivation();
        promoCodePW.clickOnSecondButtonActivatePromoCode();
        promoCodePW.checkOpenPopUpAfterActivation();
        headerMenuPW.goToNilPage();
        nilPagePW.clickOnTabPromocodeAndCheckOpenFormPromocode();
        promoCodePW.inputValidPromoCode("promoCodeSoftTnB");
        promoCodePW.checkElementsPopUpErrorReusingPromocode();
    }
    private void flowRegistationMF() {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.tapOnProfileNonAdWeb();
        authPagePW.checkOpenScreenInputPhone();
        authPagePW.inputLoginAdMWeb("+7 926 019 21 44");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPageCreatePasswordAdMWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.tapToNextNonAdWeb();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.copyPasteCodMsisdnForAdMWeb("79260192144");
        headerMenuPW.tapToComeInNonAdMWeb("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
