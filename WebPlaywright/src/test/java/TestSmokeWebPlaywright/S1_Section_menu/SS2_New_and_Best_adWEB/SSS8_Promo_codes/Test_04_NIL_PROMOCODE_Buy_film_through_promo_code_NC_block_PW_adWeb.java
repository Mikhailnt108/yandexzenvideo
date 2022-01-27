package TestSmokeWebPlaywright.S1_Section_menu.SS2_New_and_Best_adWEB.SSS8_Promo_codes;

import base.TestBasePlaywright;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.io.IOException;
import java.sql.SQLException;

@ResourceLock(value = "adWebSuitePW#3", mode = ResourceAccessMode.READ_WRITE)
public class Test_04_NIL_PROMOCODE_Buy_film_through_promo_code_NC_block_PW_adWeb extends TestBasePlaywright {
    @Epic(value = "Smoke MFTV Desktop Web")
    @Feature(value = "2. Section_menu")
    @Story(value = "2. New_and_Best_adWeb")
    @DisplayName(value = "4. NIL_PROMOCODE_Buy_film_through_promo_code")
    @Severity(SeverityLevel.BLOCKER)
    //    @TmsLink("31542006")
    @Test
    @Tag("adWebSuitePW#3")
    public void NIL_PROMOCODE_Buy_film_through_promo_code() throws IOException, InterruptedException, SQLException {
        promoCodePW.createAndPublishedRC();
        promoCodePW.createAndPublishedCodeGroupAndPromoCodeFilmOnEST();
        headerMenuPW.goToNilPage();
        flowRegistationMF();
        nilPagePW.clickOnTabPromocodeAndCheckOpenFormPromocode();
        promoCodePW.inputValidPromoCode("promoCodeFilmOnEST");
        promoCodePW.clickOnFirstButtonActivatePromoCode();
        promoCodePW.checkOpenPopUpBeforeActivation();
        promoCodePW.checkElementsPopUpBeforeActivationFilmOnEST();
        promoCodePW.clickOnSecondButtonActivatePromoCode();
        promoCodePW.checkOpenPopUpAfterActivation();
        promoCodePW.checkElementsPopUpAfterActivationFilmOnEST();
        promoCodePW.clickToButtonWatchAndCheckOpenCardFilmOnEST();
        promoCodePW.archiveCodeGroupFilmOnEST();
        headerMenuPW.deleteAccountMF("79260192144");
    }
    private void flowRegistationMF() throws SQLException {
        headerMenuPW.checkNotLoggedIsCorrect();
        headerMenuPW.clickToEnter();
        authPagePW.checkOpenPopUpInputPhone();
        authPagePW.inputLoginAdWeb("+7 926 019 21 44");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPageCreatePasswordForAdWebFlowRegistrationMF("+7 926 019 21 44", "111111");
        headerMenuPW.clickToNext();
        headerMenuPW.checkOpenPopUpInputCode();
        headerMenuPW.inputCodeMsisdnFromDB("79260192144");
        headerMenuPW.clickToComeIn("Войти");
        headerMenuPW.checkLoginUserIsCorrectFlowForMfOrNonMf();
        headerMenuPW.chooseBucket110InCmsHh("79260192144");
    }
}
